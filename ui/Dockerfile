FROM node:10.15.0 AS build
WORKDIR /usr/src/app
COPY . ./
ENV CI true
RUN yarn
RUN yarn build

FROM nginx:1.14.2
LABEL maintainer="Ed Briggler - <edward.briggler@gmail.com>"
COPY --from=build /usr/src/app/build /usr/share/nginx/html
COPY ./mime.types /etc/nginx/mime.types
COPY ./nginx.conf /etc/nginx/nginx.conf
COPY ./app.conf /etc/nginx/conf.d/app.conf

RUN chown -R nginx:nginx /usr/share/nginx/html

CMD ["nginx", "-g", "daemon off;"]