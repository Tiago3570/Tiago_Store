const MergeJsonWebpackPlugin = require("merge-jsons-webpack-plugin");


module.exports = {
  plugins: [
    new MergeJsonWebpackPlugin({
      output: {
        groupBy: [
          {
            pattern: "./src/main/webapp/assets/i18n/fr/*.json",
            fileName: "pp.json"
          }
        ]
      }
    })
  ]
};
