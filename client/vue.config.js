module.exports = {
  transpileDependencies: ['vuetify'],
  devServer: {
    port: 4300,
    open: true
  },
  runtimeCompiler: true,
  chainWebpack: config => {
    config.module
      .rule('eslint')
      .use('eslint-loader')
      .options({
        fix: true
      });
  }
};
