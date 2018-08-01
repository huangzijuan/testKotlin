fun main(args: Array<String>) {

    //-----------------------------------------------------
    /**
     * 字符用 Char 类型表示。字符字面值用单引号括起来: '1'。
     * 特殊字符可以用反斜杠转义
     *      支持这几个转义序列：\t、 \b、\n、\r、\'、\"、\\ 和 \$。
     *      编码其他字符要用 Unicode 转义序列语法：'\uFF00'。
     */
    var aChar = '1'
    print(aChar.isDigit())//判断是不是数字
    print("\n")
    print(aChar.isLetter())//判断是不是文字

    //-----------------------------------------------------
    /**
     * 字符串 用String 类型表示。字符面值用双引号括起来："我是字符串"，如果是转义字符串，可以参考java，很像
     *
     * 字字符串是不可变的。 字符串的元素——字符可以使用索引运算符访问: s[i]。
     */
    val s = "Hello, world!\n"

//    原生字符串 使用三个引号（"""）分界符括起来，内部没有转义并且可以包含换行和任何其他字符:
    val text = """
      |Tell me and I forget.
      |Teach me and I remember.
      |Involve me and I learn.
      |(Benjamin Franklin)
    """
    //TODO trimMargin()有什么实际作用
    print(text)

    //字符串相加 ；字符串和字符相加
    var str = "one"+ 'd'+ "two" + 't'

    //字符串模板：各种变量组合成一个动态的字符串，模板表达式以美元符（$）开头，由一个简单的名字构成:
    val i = 10
    print("i等于${i}")
//    原生字符串和转义字符串内部都支持模板。 如果你需要在原生字符串中表示字面值 $ 字符（它不支持反斜杠转义），你可以用下列语法：
    print("小米价格是${'$'}${i}")

    //-----------------------------------------------------
    /**
     * 元组（Tuple），给多个变量同时赋值，分二元（Pair）和三元（Triple）
     */
    val (year ,month,day) = Triple(2017,"6月","14号")
    print("${year}年${month}${day}")
    val date = Triple(2017,"6月","14号")
    print("${date.first}年${date.second}${date.third}")
    //二元同上，把Triple换成Pair
}

______________________________________________________________________________________________________

fun main(args: Array<String>) {
    /**
     * 集合，
     *      集合根据特性分：
     *      1、有序可重复 -Array
     *      2、无序不重复 -Set
     *      3、无序可重复 -Map，有唯一的键（key）
     */
   /**-----------------Array--------------------*/
    // 数组在kotlin写法：1、Array<类型>；2、arrayOf(元素1,元素2,...,元素n);数组类型不可变
    var citysOne = arrayOf("1","2","3","4","5","2")//此时，数组类型不可变，大小不可变
    var citys = Array<String>(3,{"临时占用名字"})//这里相当于占位，附一个默认值
    citys.set(1,"北京")
    for (city in citys) {
        println(city)
    }
    //创建1到10的数组
    val numbers = Array(10,{i -> i+1 })
    println("数组第三个元素：${numbers[2]}")
    println("数组第四个元素：${numbers.component4()}")//获取前五个元素的快捷方法：Array.component1到5

    citysOne.distinct(); //数组去重复
    citysOne.sliceArray(1..3)//切割数组

    //mutableList:这种数组大小可变，类型不可变
    var citysTwo = mutableListOf("1","2","3","4","5","2")
    citysTwo.add("7")//加到最后面
    citysTwo.add(0,"0")//加到第一个
    citysTwo.addAll(citysOne)//加一个集合

    citysTwo.remove("0")//移除一个元素
    citysTwo.removeAt(0)//移除第一个元素
    //TODO 还有很多种方法

    /**-----------------SET--------------------*/
    //Set写法：Set<类型>  或 setOf(元素1,...元素n)；大小固定，元素类型不可变
val setOne = setOf<String>("1","2","3","4")
 val setTwo = setOf<String>("1","5","8")
 val setThree = setOf<String>("1","4")
 println("是否包含某个元素: "+setOne.contains("1"))
 println("是否包含某个集合 :"+ setOne.containsAll(setThree))
 println("转化为数组 :"+ setOne.toTypedArray())
 println("交集：" + setOne.intersect(setTwo))
 println("差集：" + setOne.subtract(setTwo))
 println("并集：" + setOne.union(setTwo))//结果默认去重复
 println("补集：" + setOne.minus(setTwo))
 //MutableSet<类型>  或  mutableSetOf(元素1,...元素n)；大小可变，类型不可变
 /**
  * 集合相关方法
  */
 val  mutableSet = setOne.toMutableSet()
 //添加元素：add方法；添加集合：addAll方法
 //移除元素：remove方法；移除另一个集合：removeAll方法
 mutableSet.add("11")
 mutableSet.addAll(setTwo)
 mutableSet.remove("1")
 mutableSet.removeAll(setTwo)

 /**-----------------Map--------------------*/
 /**
  * Map集合类型：无序可重复
  * Map写法：mapOf<key,value>(Pair(key,"value),...)
  */
 val mapOne = mapOf<String,String>(Pair("keyOne","valueOne"), Pair("keyTwo","valueTwo"))
//相关API
 println("map里面元素个数 :"+mapOne.size)
 println("map是否为空 ：" + mapOne.isEmpty())
 println("根据键获取value ：" + mapOne.get("keyOne"))
 println("根据键获取value ：" + mapOne.getOrDefault("keyOne","不存在keyOne,这里显示默认的"))
 //获取所有的key
 for (key in mapOne.keys){
  println("集合的所有key："+key)
 }
 for (value in mapOne.values){
  println("集合所有的value ："+value)
 }

 //上面mapof初始化的MAP是不可改变的，如果需要改变，可以通过以下方法
 val mapTwo = mapOne.toMutableMap()
 mapTwo["keyOne"] = "更新keyValue"
 mapTwo["keyThree"] = "增加的value"
}


______________________________________________________________________________________________________

fun main(args: Array<String>) {
   //----------------------操作符----------------------------------/
 /**
  * 操作符：类似数学的 + - * /,用于运算或操作；用于操作对象的数目，被称之为几元操作符
  */
 //操作一个目标，是一元操作符
 var i = 1
 val j = +i
 val m = -i //这里的+ -号相当于标识是正数还是负数
 //操作两个目标，是二元操作符
 var d = i + j
 //赋值操作符，用等号右边的值更新左边的变量的值
 d = 10
 //数学操作符 + - * / %
 println( 10 + 2) //加
 println( 10 - 2)//减
 println( 10 * 2)//乘
 println( 10 / 2)//除
 println( 10 % 2)//余
 //赋值与数学操作符的组合；比如 +=  -=
 var mm =  12356
 mm += 11 // mm = mm + 11
 //比较操作符 > ; >= ; < ; <=
 println(1>2)
 println(1>=2)
 println(1<2)
 println(1<=2)
 //逻辑操作符 ： 布尔值的组合  与/或/非.这里跟java一样
 var isTrue = true
 var isFalse = false
 println("逻辑与：" + (isTrue && isFalse))
 println("逻辑或：" + (isTrue || isFalse))
 println("逻辑非："+ (!isTrue))

//----------------------控制流------------------------
 /**
  * 控制流就是进行一系列的判断，控制程序的运行流向
  * 一、循环：for，while，循环控制
  *      --for
  *        --1、依次操作一个序列（如集合类型）中的每一项，执行次数是可预测的
  *        --2、重复执行：for(a in 1..10){//操作}
  *      --while：循环执行一系列操作，知道条件不成立，适合执行次数位置的场合
  *        --循环中的控制：continue-->结束本次循环；break-->结束整个循环
  * 二、if：二元判断：条件判断语句，整个语句本身是一个表达式（可用于简单的二元判断计算）
  * 三、when：细致化判断：可对某个变量的大小/范围/值表达式/类型等进行判断
  */
// 一、循环
 val numbers = arrayOf(1,2,3,4,5)
 for (number in numbers) {
  if(number == 3) continue//结束本次循环
  println(number)
 }
 for (num in 1..100){
 println("重复执行100次")
 }
 while (i < 100){
   i += 1
  if(i == 50){
   break//结束整个循环
  }
 }
// 二、if
// 类似java，唯一的区别他可以作为一个表达式有返回值
 val a = 1
 val b = 2
 val result = if(a > b) 3 else 4
// 三、when：应用次场景，if一般用于二元判断，其他的可以考虑用when
 when (result) {//这里对result进行判断
   in 0..10-> {
    println("0到10之间")
  }
  1,3,5->{
   println("值是1,3,5中的一个")
  }
  (9-5) ->{
   println("值是4")
  }
  is Int ->{
   println("值是Int类型")
  }
  else -> {
   println("什么鬼")
  }
 }
 //----------------------函数------------------------

 val x = add(3,4)//也可以写成这样val x = add(x = 3,y = 4),最好不要这样写
 println("函数add ：" + add(2,3))
 println("可变参数函数 ："+ sum(1,3,4,5,7))
 println("可变参数函数 ："+ sum(*intArrayOf(2,3,4,5,7)))//数组前加个 * 号
}
/**
 * 函数是有名字的一段代码块，包含参数和返回值（可选），参数可以有默认值
 */
//传进两个Int类型的参数，返回Int类型
fun add(x: Int, y: Int): Int {
 return x + y
}
//可以有默认值，如果不传，就是默认0，如果传参了，就是穿的那个参数
fun addMoren(x: Int, y: Int = 0): Int {
 return x + y
}
//可变参数修饰符
fun  sum (vararg  x :Int) :Int{
 var total = 0;
 for (i in x){
  total += i
 }
 return total
}