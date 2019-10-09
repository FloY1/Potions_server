module.exports = {
  outputDir: '../../../../resources/static',
  publicPath:
      process.env.NODE_ENV === 'production'
      ? '/api/'
       :'/',
      devServer: {
        proxy: {
            '/': {
                target: 'http://localhost:8080',
                ws: true,
                changeOrigin: true
            },



        }
    }
}