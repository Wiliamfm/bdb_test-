FROM node
WORKDIR ./app
COPY . ./app
RUN npm install -g @angular/cli
CMD [ "npm", "start", "--prefix", "./app/" ]