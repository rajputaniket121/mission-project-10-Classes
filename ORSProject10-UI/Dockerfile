FROM nginx:alpine

# Remove default config
RUN rm -rf /usr/share/nginx/html/*

# Copy Angular build
COPY dist/orsproject10-ui /usr/share/nginx/html/orsproject10-ui

# Copy custom nginx config
COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 4200

CMD ["nginx", "-g", "daemon off;"]
