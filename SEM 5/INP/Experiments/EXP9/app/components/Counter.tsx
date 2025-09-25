"use client";

import React, { useEffect, useState } from 'react';

const Counter: React.FC = () => {
    const [count, setCount] = useState<number>(0);
    const [name, setName] = useState<string>('Visitor');

    useEffect(() => {
        console.log(`Counter mounted or updated: ${name}'s count is ${count}`);

        return () => {
            console.log('Cleanup for counter effect');
        };
    }, [count, name]);

    const increment = () => setCount(prev => prev + 1);
    const decrement = () => setCount(prev => prev - 1);
    const reset = () => setCount(0);

    return (
        <div style={{ padding: '20px', border: '2px solid #4CAF50', margin: '10px', borderRadius: '8px' }}>
            <h2>Counter Component (useState Demo)</h2>
            <div style={{ marginBottom: '15px' }}>
                <label>
                    Name:
                    <input
                        type="text"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                        style={{ marginLeft: '10px', padding: '5px' }}
                    />
                </label>
            </div>
            <div style={{ fontSize: '24px', marginBottom: '15px' }}>
                {name}'s Count: <strong>{count}</strong>
            </div>
            <div>
                <button onClick={increment} style={{ margin: '5px', padding: '8px 16px' }}>
                    Increment +
                </button>
                <button onClick={decrement} style={{ margin: '5px', padding: '8px 16px' }}>
                    Decrement -
                </button>
                <button onClick={reset} style={{ margin: '5px', padding: '8px 16px', backgroundColor: '#ff4444', color: 'white' }}>
                    Reset
                </button>
            </div>
        </div>
    );
};

export default Counter;