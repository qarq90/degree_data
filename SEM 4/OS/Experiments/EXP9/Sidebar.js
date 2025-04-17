import React from "react";
import { Drawer, List, Divider, Avatar } from "@material-ui/core";
import { ListItem, ListItemIcon, ListItemText } from "@material-ui/core";
import {
    Home,
    Mail,
    Message,
    Notifications,
    AccountCircle,
} from "@material-ui/icons";

const Sidebar = ({ open, onClose, user }) => {
    return (
        <Drawer open={open} onClose={onClose}>
            <div className="sidebar">
                <div className="sidebar-header">
                    <Avatar src={user.photoURL} alt={user.displayName} />
                    <div className="user-info">
                        <h3>{user.displayName}</h3>
                        <p>{user.email}</p>
                    </div>
                </div>
                <Divider />
                <List>
                    <ListItem button onClick={onClose}>
                        <ListItemIcon>
                            <Home />
                        </ListItemIcon>
                        <ListItemText primary="Home" />
                    </ListItem>
                    <ListItem button onClick={onClose}>
                        <ListItemIcon>
                            <Mail />
                        </ListItemIcon>
                        <ListItemText primary="Messages" />
                    </ListItem>
                    <ListItem button onClick={onClose}>
                        <ListItemIcon>
                            <Message />
                        </ListItemIcon>
                        <ListItemText primary="Chats" />
                    </ListItem>
                    <ListItem button onClick={onClose}>
                        <ListItemIcon>
                            <Notifications />
                        </ListItemIcon>
                        <ListItemText primary="Notifications" />
                    </ListItem>
                    <ListItem button onClick={onClose}>
                        <ListItemIcon>
                            <AccountCircle />
                        </ListItemIcon>
                        <ListItemText primary="Profile" />
                    </ListItem>
                </List>
                <Divider />
                <div className="sidebar-footer">
                    <h4>Connect with us</h4>
                    <div className="social-icons">
                        <a href="#">
                            <i className="fab fa-facebook-square"></i>
                        </a>
                        <a href="#">
                            <i className="fab fa-twitter"></i>
                        </a>
                        <a href="#">
                            <i className="fab fa-instagram"></i>
                        </a>
                    </div>
                </div>
                <div className="sidebar-copyright">
                    <p>&copy; 2022 Social Media App. All rights reserved.</p>
                </div>
            </div>
        </Drawer>
    );
};
