import requests
import time
import concurrent.futures
import random

# API 엔드포인트 리스트
APIS = [
    "http://localhost:9001/card/cards",
    "http://localhost:9001/user/test"
]

def send_request():
    url = random.choice(APIS)
    try:
        start_time = time.time()
        response = requests.get(url, timeout=5)
        end_time = time.time()
        return {
            'url': url,
            'status_code': response.status_code,
            'response_time': end_time - start_time
        }
    except requests.RequestException as e:
        return {
            'url': url,
            'status_code': 'Error',
            'response_time': 0,
            'error': str(e)
        }

def stress_test(total_requests, max_workers):
    start_time = time.time()
    results = []
    
    with concurrent.futures.ThreadPoolExecutor(max_workers=max_workers) as executor:
        futures = [executor.submit(send_request) for _ in range(total_requests)]
        
        for future in concurrent.futures.as_completed(futures):
            results.append(future.result())
    
    end_time = time.time()
    
    success_count = sum(1 for r in results if r['status_code'] == 200)
    error_count = total_requests - success_count
    
    print(f"Total requests: {total_requests}")
    print(f"Successful requests: {success_count}")
    print(f"Failed requests: {error_count}")
    print(f"Time taken: {end_time - start_time:.2f} seconds")
    print(f"Requests per second: {total_requests / (end_time - start_time):.2f}")

    # 각 URL별 결과 집계
    for url in APIS:
        url_results = [r for r in results if r['url'] == url]
        url_success = sum(1 for r in url_results if r['status_code'] == 200)
        url_error = len(url_results) - url_success
        avg_response_time = sum(r['response_time'] for r in url_results) / len(url_results) if url_results else 0
        
        print(f"\nResults for {url}:")
        print(f"  Total requests: {len(url_results)}")
        print(f"  Successful requests: {url_success}")
        print(f"  Failed requests: {url_error}")
        print(f"  Average response time: {avg_response_time:.4f} seconds")

    return results

if __name__ == "__main__":
    total_requests = 1000  # 총 요청 수
    max_workers = 10       # 동시 요청 수

    stress_test(total_requests, max_workers)
