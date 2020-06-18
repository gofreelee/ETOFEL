module.exports = {
    devServer: {
        proxy: {
            '/login': {
                target: 'http://localhost:8089/loginmodule/',
                changeOrigin: true,
                pathRewrite: {
                    '^/login': ''
                }
            },
            '/course': {
                target: 'http://localhost:8088/course/',
                changeOrigin: true,
                pathRewrite: {
                    '^/course': ''
                }
            },
            '/user': {
                target: 'http://localhost:8087/user/',
                changeOrigin: true,
                pathRewrite: {
                    '^/user': ''
                }
            },
            '/group': {
                target: 'http://localhost:8777/group/',
                changeOrigin: true,
                pathRewrite: {
                    '^/group': ''
                }
            },
            '/article': {
                target: 'http://localhost:8086/articlemodule/',
                changeOrigin: true,
                pathRewrite: {
                    '^/article': ''
                }
            }
        },
        port: 80
    },
    configureWebpack: {
        resolve: {
            alias: {
            'assets': '@/assets',
            'components': '@/components',
            'view': '@/view',
            }
        }
      }
};