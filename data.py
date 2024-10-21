from flask import Flask, jsonify
import pandas as pd
from sklearn.cluster import KMeans

app = Flask(__name__)

@app.route('/analyze/user-segments', methods=['GET'])
def analyze_user_segments():
    # 사용자 데이터 로드 (실제로는 데이터베이스에서 가져올 것입니다)
    df = pd.read_csv('user_data.csv')
    
    # K-means 클러스터링 수행
    kmeans = KMeans(n_clusters=3, random_state=42)
    df['Cluster'] = kmeans.fit_predict(df[['Age', 'Income', 'SpendingScore']])
    
    # 결과 집계
    segment_summary = df.groupby('Cluster').agg({
        'Age': 'mean',
        'Income': 'mean',
        'SpendingScore': 'mean',
        'Cluster': 'count'
    }).rename(columns={'Cluster': 'Count'}).reset_index()
    
    return jsonify(segment_summary.to_dict('records'))

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)
