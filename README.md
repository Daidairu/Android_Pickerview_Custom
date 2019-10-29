# Android_Pickerview_Custom
以 https://github.com/Bigkoo/Android-PickerView 為基底, 新增一個可以顯示星期幾的功能

使用時下載整個專案，然後 import module ，選擇 pickerview ， 會連 wheelview 一起 import 進來。


使用 TimePickerView 時，多了兩個功能可使用(限公曆)
1. .setShowWeekDay(boolean canShow)   使用這個功能決定你要不要顯示星期幾。
2. .setTimeRange(int timeRange)       增加時間間距 (ex:5.10.15.20)



1.原理是改寫原本套件的adapter，由年月日判斷星期幾，然後加在後面。

2.原理也是改寫原本套件的adapter，但是多了計算時間間距決定adapter長度；因為原本套件取得時間方法是直接拿adapter位置(timeRange=1)，在有時間間距的情況下(timeRange>1)，獲得時間也要另外寫方法來取得。