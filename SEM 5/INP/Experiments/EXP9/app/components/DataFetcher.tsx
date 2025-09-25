"use client";

import React, { useEffect, useState } from 'react';

interface Post {
    id: number;
    title: string;
    body: string;
}

const DataFetcher: React.FC = () => {

    const [posts, setPosts] = useState<Post[]>([]);
    const [loading, setLoading] = useState<boolean>(true);
    const [error, setError] = useState<string | null>(null);
    const [userId, setUserId] = useState<number>(1);
    const [fetchCount, setFetchCount] = useState<number>(0);

    useEffect(() => {
        console.log('Fetching posts for user:', userId);

        const fetchData = async () => {
            try {
                setLoading(true);
                setError(null);

                const response = await fetch(
                    `https://jsonplaceholder.typicode.com/posts?userId=${userId}`
                );

                if (!response.ok) {
                    throw new Error('Failed to fetch posts');
                }

                const data = await response.json();
                setPosts(data.slice(0, 3));
                setFetchCount(prev => prev + 1);
            } catch (err) {
                setError(err instanceof Error ? err.message : 'An error occurred');
            } finally {
                setLoading(false);
            }
        };

        fetchData();

        return () => {
            console.log('Cleanup: cancelling any ongoing requests');
        };
    }, [userId]);

    useEffect(() => {
        document.title = `User ${userId} - ${posts.length} posts`;

        return () => {
            document.title = 'React App';
        };
    }, [userId, posts.length]);

    const changeUser = (newUserId: number) => {
        if (newUserId >= 1 && newUserId <= 10) {
            setUserId(newUserId);
        }
    };

    return (
        <div style={{ padding: '20px', border: '2px solid #FF9800', margin: '10px', borderRadius: '8px' }}>
            <h2>Data Fetcher Component (useEffect Demo)</h2>

            <div style={{ marginBottom: '15px' }}>
                <label>
                    Select User ID (1-10):
                    <input
                        type="number"
                        value={userId}
                        onChange={(e) => changeUser(parseInt(e.target.value) || 1)}
                        min="1"
                        max="10"
                        style={{ marginLeft: '10px', padding: '5px', width: '60px' }}
                    />
                </label>
                <span style={{ marginLeft: '15px', color: '#666' }}>
                    Fetched {fetchCount} time(s)
                </span>
            </div>

            {loading && <div style={{ padding: '10px', backgroundColor: '#fff3cd' }}>Loading posts...</div>}

            {error && (
                <div style={{ padding: '10px', backgroundColor: '#f8d7da', color: '#721c24' }}>
                    Error: {error}
                </div>
            )}

            {!loading && !error && (
                <div>
                    <h3>Posts for User {userId}:</h3>
                    {posts.length === 0 ? (
                        <p>No posts found for this user.</p>
                    ) : (
                        <div style={{ display: 'grid', gap: '10px' }}>
                            {posts.map(post => (
                                <div key={post.id} style={{
                                    padding: '10px',
                                    border: '1px solid #ddd',
                                    borderRadius: '4px',
                                }}>
                                    <h4 style={{ margin: '0 0 5px 0' }}>{post.title}</h4>
                                    <p style={{ margin: 0, fontSize: '14px' }}>{post.body}</p>
                                </div>
                            ))}
                        </div>
                    )}
                </div>
            )}
        </div>
    );
};

export default DataFetcher;