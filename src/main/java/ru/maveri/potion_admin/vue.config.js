module.exports = {
  outputDir: '../../../../resources/static',
  publicPath:
      process.env.NODE_ENV === 'production'
      ? '/api/'
       :'/',
      devServer: {
        proxy: {
            '/': {
                target: 'http://localhost:8081',
                ws: true,
                changeOrigin: true
            },



        }
    }
}