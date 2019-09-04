const ForkTsCheckerWebpackPlugin = require('fork-ts-checker-webpack-plugin-alt');

module.exports = (config, env) => {
   var pluginsWithoutForkTs = [];
   for (var i = 0; i < config.plugins.length; i++) {
       if (config.plugins[i] instanceof ForkTsCheckerWebpackPlugin) {
           config.plugins[i].async = true;
       }
       pluginsWithoutForkTs.push(config.plugins[i]);
   }
   config.plugins = pluginsWithoutForkTs;
   return config;
}
