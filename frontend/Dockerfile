# Stage 1: Build the Angular app
FROM node:20 as build

WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build --prod

# Stage 2: Serve the app using NGINX
FROM nginx:latest

COPY --from=build /app/dist/frontend/browser /usr/share/nginx/html

# Copy NGINX config to the proper location
COPY default.conf /etc/nginx/conf.d/default.conf

CMD ["nginx", "-g", "daemon off;"]
