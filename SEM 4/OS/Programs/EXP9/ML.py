# machine learning code in python

import numpy as np
from sklearn.datasets import fetch_openml
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import accuracy_score

# Load the MNIST dataset

mnist = fetch_openml('mnist_784', version=1)
X, y = mnist['data'], mnist['target']

# Convert the target values to integers

y = y.astype(np.int)

# Split the dataset into training and testing sets

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Normalize the input features

X_train = X_train / 255.0
X_test = X_test / 255.0

# Initialize the logistic regression model

model = LogisticRegression(max_iter=1000, solver='lbfgs', multi_class='multinomial')

# Train the model

model.fit(X_train, y_train)

# Make predictions on the testing set

y_pred = model.predict(X_test)

# Calculate the accuracy

accuracy = accuracy_score(y_test, y_pred)
