# buckwheat-int20h

## Overview

Website for viewing prices on buckwheat from Ukrainian online stores

### Prerequisites

1. Node + npm
2. Maven + OpenJDK
3. Docker

### Installation

```
npm install
```

### Building

```
npm run build
```

### Run

Before running you need to get `SERP_WOW_TOKEN`.  
More info about this token can be found [here](./buckwheat-service/README.md)

Run:

```
export SERP_WOW_TOKEN=YOUR_TOKEN
```

```
npm start
```

Application runs on <http://localhost:5000>

To run in dev mode:

```
npm run dev
```

In development mode client accessible on <http://localhost:3000>

### Heroku

To deploy on `heroku` run:

```
node heroku-deploy.js
```

Version of running up: <https://tranquil-badlands-98489.herokuapp.com/>

### Buckwheat prices service

> `Buckwheat prices service` is a service that scraps info about иuckwheat porridge from different stores using Google Content API for Shopping

To build `Buckwheat prices service` run:

```
npm run price-service:build
```

To build `docker` image with it run:

```
npm run docker:build
```

To run `Buckwheat prices service` in `docker`:

1. Set environment variables:

```
export DOCKER_PORT=PORT_TO_ACCESS_SERVICE
```

```
export SERP_WOW_TOKEN=YOUR_TOKEN
```

More info about this token can be found [here](./buckwheat-service/README.md)

2. Run `docker` container:

```
npm run docker:start
```

Service available on <http://localhost:PORT_TO_ACCESS_SERVICE/v1/prices/buckwheat>

### Usefull resources

- [Buckweat images](https://www.google.com/search?q=buckwheat&client=ubuntu&hs=Ct1&channel=fs&sxsrf=ALeKk00OFw8y4zvhSVM7NqiWHbxpmlM89w:1611090841175&source=lnms&tbm=isch&sa=X&ved=2ahUKEwiJvaeK9ajuAhWolIsKHSq7AAsQ_AUoAXoECAwQAw&biw=2310&bih=1186)
