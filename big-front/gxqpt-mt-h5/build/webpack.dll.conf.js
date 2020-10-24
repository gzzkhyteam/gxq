// 外部引入dll文件
const webpack = require('webpack');
const path = require('path');
const isDebug = process.env.NODE_ENV === 'development';
const ExtractTextPlugin = require('extract-text-webpack-plugin'); // 提取css
const AssetsPlugin = require('assets-webpack-plugin'); // 生成文件名，配合HtmlWebpackPlugin增加打包后dll的缓存
const outputPath = isDebug ? path.join(__dirname, '../dist/gxqpt-attendance/common/debug') : path.join(__dirname, '../dist/gxqpt-attendance/common/dist');
const fileName = '[name].js';
const pkg = require('../package.json'); // 引入package.json
// 资源依赖包，提前编译
const lib = [
    'vue',
    'vue-router',
    'vuex',
    // 'axios',
    // 'muse-ui',
    // 'mint-ui',
    // 'babel-polyfill',
    // 'autosize',
    // 'muse-ui-loading',
    // 'muse-ui-toast',
    // 'vue-textarea-autosize',
    // 'muse-ui/lib/styles/base.less',
    // 'muse-ui/lib/styles/theme.less',
    // 'mint-ui/lib/style.css',
];
const plugin = [
    new webpack.DllPlugin({
        /**
         * path
         * 定义 manifest 文件生成的位置
         * [name]的部分由entry的名字替换
         */
        path: path.join(outputPath, 'manifest.json'),
        /**
         * name
         * dll bundle 输出到那个全局变量上
         * 和 output.library 一样即可。
         */
        name: '[name]',
        context: __dirname
    }),
    // new webpack.optimize.OccurenceOrderPlugin()
];
const modules = {
    rules: [
        {
            test: /\.css$/,
            use: ExtractTextPlugin.extract({
                fallback: "style-loader",
                use: "css-loader"
            })
        },
        // {
        //     test: /\.less$/,
        //     use: ExtractTextPlugin.extract({
        //         use: [{
        //             loader: 'css-loader'
        //         }, {
        //             loader: 'less-loader'
        //         }],
        //         fallback: 'style-loader'
        //     })
        // },
        {
            test: /\.(png|jpe?g|gif|svg)(\?.*)?$/,
            loader: 'url-loader',
            query: {
                limit: 10000,
                name: 'img/[name].[hash:7].[ext]'
            }
        },
        {
            test: /\.(woff2?|eot|ttf|otf)(\?.*)?$/,
            loader: 'url-loader',
            query: {
                limit: 10000,
                name: 'fonts/[name].[hash:7].[ext]'
            }
        }
    ]
};
if (!isDebug) {
    plugin.push(
        new ExtractTextPlugin('[name].css'),
        new webpack.DefinePlugin({
            'process.env.NODE_ENV': JSON.stringify('production')
        }),
        new webpack.optimize.UglifyJsPlugin({
            mangle: {
                except: ['$', 'exports', 'require']
            },
            compress: { warnings: false },
            output: { comments: false }
        }),
        new AssetsPlugin({
            filename: 'bundle-config.json',
            path: '.'
        }),
    )
}
module.exports = {
    devtool: '#source-map',
    entry: {
        lib: lib
    },
    output: {
        path: outputPath,
        filename: fileName,
        /**
         * output.library
         * 将会定义为 window.${output.library}
         * 在这次的例子中，将会定义为`window.vendor_library`
         */
        library: '[name]',
        libraryTarget: 'umd',
        umdNamedDefine: true
    },
    plugins: plugin,
    module: modules
};