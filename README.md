# Android_Pickerview_Custom
以 https://github.com/Bigkoo/Android-PickerView 為基底, 新增一個可以顯示星期幾的功能

使用時下載整個專案，然後 import module ，選擇 pickerview ， 會連 wheelview 一起 import 進來。

使用 TimePickerView 時，多了一個 .setShowWeekDay(boolean) 可使用，
使用這個功能決定你要不要顯示星期幾。


原理是改寫原本套件的adapter，由年月日判斷星期幾，然後加在後面。

