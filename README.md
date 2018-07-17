# Android - RefreshAndLoadMore Demo #

一种简单的并且优雅的方式实现下拉刷新和加载更多的分页效果。

包含 ListView 和 RecyclerView 两种组件的对应实现。

下拉刷新基于 SwipeRefreshLayout 实现。

加载更多通过在列表底部添加 FooterView 实现。

考虑了第一次请求数据填充不足一屏的特殊情况。

ListView 做了少许扩展以便支持 addOnScrollListener。

使用了 [HeaderAndFooterRecyclerView](https://github.com/TakWolf/Android-HeaderAndFooterRecyclerView) 让 RecyclerView 支持添加 FooterView。

![](https://github.com/TakWolf/static.takwolf.com/raw/master/github/Android-RefreshAndLoadMore-Demo/01.gif)

请在[这里](https://fir.im/refreshandloadmore)下载示例程序。

对应文章说明，请查看 [http://blog.takwolf.com/2017/06/15/android-refresh-and-load-more-demo](http://blog.takwolf.com/2017/06/15/android-refresh-and-load-more-demo)

## Author ##

TakWolf

[takwolf@foxmail.com](mailto:takwolf@foxmail.com)

[http://takwolf.com](http://takwolf.com)

## License ##

```
Copyright 2017 TakWolf

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
