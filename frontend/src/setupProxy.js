const { createProxyMiddleware } = require('http-proxy-middleware'); // eslint-disable-line
module.exports = function (app) {
    app.use(
        '/api',
        createProxyMiddleware({
            target: process.env.BACKEND_PROXY,
            // target: 'http://localhost:8080',
            changeOrigin: true, //stop here for original
            // pathRewrite: {
            //     '^/api': '', // remove /api from the request path
            // },
            onProxyReq: (proxyReq, req, res) => { // eslint-disable-line
                console.log('Proxying request to:', 'http://localhost:8080');
                console.log('Original request path:', req.originalUrl);
                console.log('Proxied request path:', proxyReq.path);
              },
            onError: (err, req, res) => { // eslint-disable-line
                console.error('Proxy error:', err);
              },
            onProxyRes: (proxyRes, req, res) => { // eslint-disable-line
                console.log('Received response from target:', proxyRes.statusCode);
              },
            })
          );
        };
