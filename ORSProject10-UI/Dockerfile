FROM nginx:alpine

# Remove default nginx config
RUN rm -rf /usr/share/nginx/html/*

# Copy already-built Angular dist
COPY dist/orsproject10-ui/ /usr/share/nginx/html/

EXPOSE 4200

CMD ["nginx", "-g", "daemon off;"]
