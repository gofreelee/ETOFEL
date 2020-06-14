module.exports = {
    devServer: {
        proxy: {
            '/login': {
                target: 'http://localhost:8089/loginmodule/',
                changeOrigin: true,
                pathRewrite: {
                    '^/login': ''
                }
            }
        },
        port: 80
    }
};