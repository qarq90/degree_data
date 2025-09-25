"use client";

import React, { createContext, useContext, useState } from 'react';

interface User {
    name: string;
    email: string;
    role: string;
}

const defaultUser: User = {
    name: 'Guest',
    email: 'guest@example.com',
    role: 'user'
};

const UserContext = createContext<User>(defaultUser);

const UserProfile: React.FC = () => {

    const [user, setUser] = useState<User>(defaultUser);
    const [isEditing, setIsEditing] = useState<boolean>(false);
    const [tempUser, setTempUser] = useState<User>(user);

    const handleSave = () => {
        setUser(tempUser);
        setIsEditing(false);
    };

    const handleCancel = () => {
        setTempUser(user);
        setIsEditing(false);
    };

    return (
        <UserContext.Provider value={user}>
            <div style={{ padding: '20px', border: '2px solid #2196F3', margin: '10px', borderRadius: '8px' }}>
                <h2>User Profile Component (useContext Demo)</h2>

                {isEditing ? (
                    <EditForm
                        user={tempUser}
                        onUserChange={setTempUser}
                        onSave={handleSave}
                        onCancel={handleCancel}
                    />
                ) : (
                    <ProfileDisplay
                        onEdit={() => setIsEditing(true)}
                    />
                )}
            </div>
        </UserContext.Provider>
    );
};

const ProfileDisplay: React.FC<{ onEdit: () => void }> = ({ onEdit }) => {
    const user = useContext(UserContext);

    return (
        <div>
            <div style={{ marginBottom: '15px' }}>
                <h3>User Information</h3>
                <p><strong>Name:</strong> {user.name}</p>
                <p><strong>Email:</strong> {user.email}</p>
                <p><strong>Role:</strong> {user.role}</p>
            </div>
            <button
                onClick={onEdit}
                style={{ padding: '8px 16px', backgroundColor: '#2196F3', color: 'white' }}
            >
                Edit Profile
            </button>
        </div>
    );
};

// Edit form component
const EditForm: React.FC<{
    user: User;
    onUserChange: (user: User) => void;
    onSave: () => void;
    onCancel: () => void;
}> = ({ user, onUserChange, onSave, onCancel }) => {

    const handleChange = (field: keyof User, value: string) => {
        onUserChange({ ...user, [field]: value });
    };

    return (
        <div>
            <h3>Edit Profile</h3>
            <div style={{ marginBottom: '10px' }}>
                <label>
                    Name:
                    <input
                        type="text"
                        value={user.name}
                        onChange={(e) => handleChange('name', e.target.value)}
                        style={{ marginLeft: '10px', padding: '5px', width: '200px' }}
                    />
                </label>
            </div>
            <div style={{ marginBottom: '10px' }}>
                <label>
                    Email:
                    <input
                        type="email"
                        value={user.email}
                        onChange={(e) => handleChange('email', e.target.value)}
                        style={{ marginLeft: '10px', padding: '5px', width: '200px' }}
                    />
                </label>
            </div>
            <div style={{ marginBottom: '15px' }}>
                <label>
                    Role:
                    <select
                        value={user.role}
                        onChange={(e) => handleChange('role', e.target.value)}
                        style={{ marginLeft: '10px', padding: '5px' }}
                    >
                        <option value="user">User</option>
                        <option value="admin">Admin</option>
                        <option value="moderator">Moderator</option>
                    </select>
                </label>
            </div>
            <button onClick={onSave} style={{ marginRight: '10px', padding: '8px 16px', backgroundColor: '#4CAF50', color: 'white' }}>
                Save
            </button>
            <button onClick={onCancel} style={{ padding: '8px 16px', backgroundColor: '#ff4444', color: 'white' }}>
                Cancel
            </button>
        </div>
    );
};

export default UserProfile;