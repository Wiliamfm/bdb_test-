FROM node
WORKDIR ./app
COPY . ./app
RUN npm install -g @angular/cli
EXPOSE 4200
CMD [ "npm", "start", "--prefix", "./app/" ]