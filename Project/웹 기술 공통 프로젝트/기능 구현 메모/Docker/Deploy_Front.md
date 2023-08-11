# Docker를 이용한 React Project 배포

### 1. Docker 이미지 빌드 설정 만들기
- react project root 디렉토리에 `Dockerfile` 만들기
    ```

    # Use an official Node.js runtime as the base image
    FROM node:18

    # Set the working directory
    WORKDIR /app

    # Copy package.json and package-lock.json to the container
    COPY package*.json ./

    # Install project dependencies
    RUN npm install

    # Copy the rest of the application code
    COPY . .

    # Build the React app
    RUN npm run build

    # Specify the command to run when the container starts
    CMD ["npm", "start"]

    ```