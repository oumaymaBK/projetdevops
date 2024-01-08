FROM node:14-alpine

EXPOSE 80

WORKDIR /usr/src/app

COPY package.json ./
RUN npm install

COPY . .

CMD ["sh", "-c", "ng serve" ]
