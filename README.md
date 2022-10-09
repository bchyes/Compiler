Compiler-2022
目录
目录
一、项目概述
1. About the course
2. Grading Policy
3. 禁止行为
4. 其他说明
二、Mx* 语言定义
I. 部分术语定义
II. 基本结构
III. 语法规则
1. 字符集合
2. 关键字
3. 空白符
4. 注释
5. 标识符
6. 常量
6.1. 逻辑常量
6.2. 整数常量
6.3. 字符串常量
6.4. 空值常量
7. 变量
7.1. 基础类型
7.2. 数组类型
7.3.1. 基础定义
7.3.2. 创建
7.3.3. 内建方法
7.3.4. 多维数组
8. 类
8.1. 类成员变量
8.2. 类方法
8.3. 访问类成员
8.4. 类构造函数
8.6. 其他未定义行为
9. 函数
9.1. 函数定义
9.2. 内建函数
9.3. 函数返回值
9.4. Lambda 表达式
10. 表达式
10.1. 基础表达式
10.2. 算数表达式
10.2.1 单目运算表达式
10.2.2 双目运算表达式
10.3. 赋值表达式
11. 语句
11.1. 变量声明语句
11.2. 条件语句
11.3. 循环语句
11.4. 跳转语句
11.5. 表达式语句
12. 字符串
12.1. 字符串对象
12.2. 双目运算
12.3. 内建方法
13. 作用域
14. 命名空间
三、编译说明
1. 程序输入输出
2. 评测指标和基准线的划分
3. FAQ
Document Note
一、项目概述
1. About the course
编译器设计是 ACM 班的传统课程，这门课程旨在锻炼大家的编程能力和工程能力。往年的课程都是进行天梯制度赋分，由于大家都写累了好的数据点就贡献的越来越少了，往后逐渐变成了面向数据编程，于是从 2018 级开始回归到更为重要的编译本身。因此，我们修正了原有语言中描述不清晰的部分，按照 Standard C++ 和 Java 的语言定义方式给出一个定义，并且按照两个语言的标准编译测试集合制定出一个属于我们的语言的标准测试集合。欢迎大家提出修改意见和建议。

总体上本项目分为 3 个阶段分别评测：语义检查（Semantic Check），代码生成（Codegen / Code Generation），代码优化（Optimization）。

2. Grading Policy
以该学期大助教发布内容为准。

3. 禁止行为
做出以下行为的学生，本课程总成绩将直接作 0 分处理

对数据点的特判
界定：判断数据点具有什么样的特征后输出
排除：对 AST、IR 等结构分析后对具有特定结构的程序进行优化的过程
抄袭
界定：无法通过 Code Review 或与其他学生代码相似程度过高
此项无例外排除项
调用第三方库
界定：你的代码不应该调用第三方库用于任何阶段，例如生成 LLVM IR 后直接调用 Clang 等工具完成 Codegen 等工作是违规的
排除：Parser 部分可以使用第三方库，例如 ANTLR 等；自己实现了生成工具除外
4. 其他说明
关于服务器：服务器可能有漏洞，如果可以提供对服务器封堵漏洞的好的建议是十分欢迎的。在不通知负责助教的情况下，任何对服务器的破坏性行为会导致请喝茶以及支付由此产生的额外服务器维护费用

关于本文档：本文档参照 ISO/IEC 14882:2017 Programming Language C++ 以及往年的 Manual 做出修改。如果对数据或文档有疑问或者认为数据或文档存在错误的，请发起 Issue。如果发现有可修复的错误可以直接发起 Pull Requests，十分感谢！

二、Mx* 语言定义
I. 部分术语定义
未定义行为：指规范并没有定义该情况发生时语言的表现。初衷是为了给同学们提供一些自己发挥的空间，在测试数据里，这些没有定义的情况是不会发生的。可以认为未定义行为是类似于运行时会错误的东西，由于在编译阶段无法确定，因此我们就保证我们的代码不会出现
示例：对长度超过 1M 的代码的编译是未定义的

说明：我们的测试集合中不会出现长度超过 1M 的代码

语法错误：指代码违反规范的行为，你的编译器应返回非 0 返回值作为编译错误指示信息（必须实现，作为评测标准之一）以及你的提示信息（可选实现，评测不涉及）

源代码：你的编译器即将编译的 Mx* 代码

II. 基本结构
一份标准的 Mx* 语言代码包含有以下部分：
大于等于 1 个函数定义
类定义（可选）
全局变量声明（可选）
函数定义中有且仅有 1 个函数的名字可以为 main，main 函数的定义仅可为 int main()。不符合此定义的 main 函数或者 main 函数缺失均视为语法错误

Mx* 语言无函数接口定义，所有的函数定义必须有对应的函数体。函数体缺失视为语法错误

编译 1MB 大小以上的代码是未定义行为

III. 语法规则
1. 字符集合
Mx* 语言对大小写敏感，合法字符集合如下：

标识符（包括变量标识符、函数标识符、类对象标识符）：26 个小写英语字母，26 个大写英语字母，数码 0 到 9，下划线 _

标准运算符：加号 +，减号 -，乘号 *，除号 /，取模 %

关系运算符：大于 >，小于 <，大于等于 >=，小于等于 <=，不等于 !=，等于==

逻辑运算符：逻辑与 &&，逻辑或 ||，逻辑取反 !

位运算符：算术右移 >>，算术左移 <<，按位与 &，按位或 |，按位异或 ^，按位取反 ~

赋值运算符：赋值 =

自增运算符：自增 ++，自减 --

分量运算符：对象 .

下标运算符：取下标对象 []

优先级运算符：括号 ()

分隔符：分号 ;，逗号 ,，括号 {}

特殊符号：空格 ，换行符 \n，制表符 \t，注释标识符 //，字符串标识符 "

不包括在以上符号集合内的符号出现在源代码中（除字符串常量外）视为语法错误。

字符串常量的字符集定义见 6.3. 字符串常量 。

2. 关键字
Mx* 语言共有 13 个关键字：

void, bool, int, string, new, class, null, true, false, this, if, else, for, while, break, continue, return

3. 空白符
空白符、制表符、换行符在 Mx* 语言中除区分词素（Token）以外没有作用

4. 注释
行注释：从 // 到这一行末尾的所有内容（包括 //）都会被作为注释，编译的时候应当自动忽略。

Mx* 语言有且仅有一种注释语法，其他 C++ 语言的注释语法视为未定义行为（欢迎尝试实现）。

5. 标识符
标识符的第一个字符必须为英语字母，第二个字符开始可以是英语字母、数字或者下划线。

标识符区分大小写并且长度超过 64 个字符的标识符是未定义的。

6. 常量
注：没有在以下定义的常量都是未定义的。

6.1. 逻辑常量
定义 true 为真，false 为假。

6.2. 整数常量
整数常量以十进制表示，整数常量不设负数，负数可以由正数取负号得到。

编译器至少应该能处理大小范围在  内的整数，首位为 0 的整数常量是未定义的（整数 0 除外），大小超过上述范围的整数是未定义的。

6.3. 字符串常量
字符串常量是由双引号括起来的字符串。

字符串长度最小为 0 ，长度超过 255 的字符串是未定义的。

字符串中的所有字符必须是可示字符（Printable character），空格或者转义字符中的一种。

转义字符有三种：\n 表示换行符，\\ 表示反斜杠，\" 表示双引号。

其余出现在 C++ 语言中的转义字符是未定义的。

6.4. 空值常量
定义 null 为引用类型的不指向任何对象的值。

7. 变量
7.1. 基础类型
bool 类型：true（真）或 false（假）

int 类型：大小范围在  内的整数

void 类型：表明函数没有返回值的特殊类型，仅用于函数返回值类型

string 类型：字符串为引用类型，可以改变引用对象，但是字符串的值无法改变（immutable）

任何形式的类型转换（隐式类型转换，强制类型转换）在本语言中是未定义的。

7.2. 数组类型
7.2. 部分的 <typename> 指的是类型，可以是基础类型（除 void 外）也可以是类。<identifier> 指的是变量标识符

Mx* 语言的数组与 C++ 语言有较大区别，较接近 Java 语言的数组

7.3.1. 基础定义
数组是一种可以动态创建的引用类型，长度无需在声明的时候确定。

一维数组声明语句的语法格式为 <typename>[] <identifier>(=<initializationExpression>);。

例如：bool[] flag; 是一句合法声明语句

通过下标访问一维数组元素的语法格式为 <identifier>[index]。

注意：数组声明后对应变量值为 null，此时访问数组下标是未定义的

常量数组在 Mx* 语言中是未定义的，鼓励同学们进行尝试

数组类型的对象支持引用赋值，定义该行为同 Java 语言中的数组引用赋值。

引用赋值可以理解为 C++ 中直接对数组指针进行赋值

7.3.2. 创建
创建数组可以用关键字 new 创建。

创建数组的表达式的语法格式为 new <typename>[arraySize]...;。

例如：bool[] flag = new bool[10]; 是一种合法的创建方式

创建数组需指定数组的长度 arraySize，类型为整形。数组长度一定小于 。

7.3.3. 内建方法
<identifier>.size() 返回数组的长度，函数返回值为 int。调用值为 null 的数组对象的该方法是未定义行为。

7.3.4. 多维数组
Mx* 语言采用交错数组（Jagged Array）以达到多维数组的效果，声明方法和 Java 语言保持一致。

通俗而言就是 “数组的数组”，可以理解为 C++ 语言中 vector 套 vector 的效果

声明交错数组的语句语法要求为 <typename>[]... <identifier>(=<initial sentence>);

例如：声明一个 2 维数组的语句可以是：int[][] graph;

创建交错数组的语法为：new <typename>[arraySize]...[]...;

创建交叉数组的行为需要从外层至内层逐层创建数组空间。

例如：声明创建一个 2 维数组的语句可以是：

int[][] graph = new int[3][];
graph[0] = null; // Valid
graph[1] = new int[10];
graph[2] = new int[30];
交叉数组的声明创建也可以同时指定多层数组长度。

例如声明创建一个大小为 3×4 的 2 维数组的语句可以是：int[][] graph = new int[3][4];

该语句等价于：

int[][] graph = new int[3][];
graph[0] = new int[4];
graph[1] = new int[4];
graph[2] = new int[4];
8. 类
Mx* 语言的类类似于 C++ 语言

我们的语言需要面向对象，类的定义的方式如下：

class <classIdentifier> {
   // 类成员变量
   <type1> <memberIdentifier1>;
   <type2> <memberIdentifier2>, <memberIdentifier3>...;
   // 类构造函数
   <ClassIdentifier>(){ // If there is no explicit constructor, class has inexplicit default constructor.
      <expressionsAndStatements>
   }
   // 类方法
   <returnType> <functionIdentifier>(<functionParameterList>){
      <expressionsAndStatements>
   }
};
8.1. 类成员变量
所有的类成员变量的行为同 C++ 中 public 成员变量。

访问未赋初值的类成员变量是未定义行为。

8.2. 类方法
对于类方法，语法格式同 9. 函数（除构造函数外）。

类方法中可以访问 this 指针，其指向被调用该方法的对象。

不在类作用域内访问 this 指针视为语法错误，this 指针作为左值视为语法错误。

示例：

语法正确的代码片段

class foo {
    int a;
    int b;
    int c;
    foo test(){ return this; }
};
语法错误的代码片段

class foo {
    int a;
    int b;
    int c;
};
foo test(){ return this; }
8.3. 访问类成员
对于类成员不论是方法还是变量，都可以用对象标识符 . 获取对象。

对于类成员变量：访问除 string 外的基本类型 int, bool 的成员变量返回一个实值；访问其他类型成员变量返回引用。语法为：<classObjectIdentifier>.<classMember>;

对于类方法：调用语法为：<classObjectIdentifier>.<classMethod>(<functionParameterList>);

8.4. 类构造函数
构造函数的定义和 C++ 相同，无返回值无参数，语法如下：

<ClassIdentifier>(){
	<Expressions and Statements>
}
构造函数可以省略，无显式构造函数的类有默认构造函数，默认构造函数无任何行为。

带参数的构造函数是未定义语法。

8.6. 其他未定义行为
析构函数、虚函数、类的继承、接口、权限标示、抽象类、成员的默认初始化表达式、函数重载。

9. 函数
9.1. 函数定义
函数定义语法如下：

<returnType> <functionIdentifier>(<functionParameterList>){
	<expressionsAndStatements>
}
注意：在 Mx* 语言中不支持声明函数的签名，也不支持在一个函数内嵌套申明另一个子函数或类

Lambda 表达式与匿名函数在 Codegen、Optimize 阶段视为未定义行为。

9.2. 内建函数
以下内建函数不需要定义或声明就直接可以使用：

函数：void print(string str);

作用：向标准输出流中输出字符串 str
函数：void println(string str);

作用：向标准输出流中输出字符串 str，并在字符串末输出一个换行符
函数：void printInt(int n);

作用：向标准输出流中输出数字 n
函数：void printlnInt(int n);

作用：向标准输出流中输出数字 n，并且在数字末输出一个换行符
函数：string getString();

作用：从标准输入流中读取一行字符串并返回
函数：int getInt();

作用：从标准输入流中读取一个整数，读到空格、回车符、制表符处停止，返回该整数
函数：string toString(int i);

作用：把整数 i 转换为字符串并返回
9.3. 函数返回值
如果函数声明的返回值类型非 void，应有 return 语句返回函数返回值，返回值缺失为未定义行为。

例外：main 函数可以没有返回值，默认返回值为 0。

如果函数声明的返回值类型为 void，return 语句不能附带任何返回值，表示从此位置跳出函数。void 类型函数中若 return 语句有返回值，为语法错误。

在 Semantic Check 阶段，需要进行语法检查，检查返回类型非 void 的返回值的函数中每一个 return 语句的返回类型是否正确。

返回值可以是自定义类，可以是数组，可以是自定义类的数组。对于数组类型的返回值需要检查维数是否正确。

也就是 2 维数组不可以返回给 1 维数组。

但是数组长度相关问题无需检查，为未定义行为。

例如：以下的情况不会出现在测试点中：

int[] foo(int args){
  return new int[args];
}

int main(){
  int[] vec = foo(10);
  return vec[11]; // Out-of-range Exception.
}
9.4. Lambda 表达式
Lambda 表达式已经成为现代程序语言中非常重要的一个功能，它可以简化代码。例如如下的两种代码是等效的：

Arrays.sort(array, new Comparator<String>() {
    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }
});
Arrays.sort(array, (s1, s2) -> {
   return s1.compareTo(s2);
});
为了让大家熟悉 Lambda 表达式，我们的编译器需要支持一个非常简单的 Lambda 表达式。为了简化，Lambda 表达式仅出现在 Semantic Check 阶段，Codegen 与 Optimization 阶段出现 Lambda 表达式是未定义的。Lambda 表达式本身作为对象是未定义的。

同样为了简化，我们的 Lambda 表达式语法很单一，没有特别的语法糖。

基本语法：[&](Parameters) -> {Statements}，[](Parameters) -> {Statements}

解释：定义同函数。如果参数为空，参数括号可以省略，调用括号不可以省略。不含[&]时该内部Statement不可以调用外部的全局变量，仅当存在[&]时，内部的Statement可以调用外部的对象。

作用域的解释：Parameters 如果出现和全局域重名的变量，应当遵循作用域遮蔽原则。

在这里，我们借用 C++ 中省略返回值的形式。你的编译器应该支持通过 return 语句分析返回值并判断，如果 Lambda 表达式函数体没有 return 语句，那么返回值为 void。

参数可以留空。

Lambda 表达式的调用同函数。

示例：

int sum = [&](int a, int b) -> { return a + b; }(1, 2); // 正确
int sum2 = [&]() -> { return sum; }(12); // 错误
int sum3 = [&]() -> { return sum; }(); // 正确
int foo = [&] -> {return 1;}(); // 正确
10. 表达式
10.1. 基础表达式
包括单独出现的常量，变量和 this 指针，函数调用，对象成员访问，数组访问，new 表达式。

10.2. 算数表达式
语法与具体行为参考 C++。

10.2.1 单目运算表达式
前缀 / 后缀自增 ++ / 自减 -- 表达式

取非 ! / 取反 ~ / 取负 - 表达式

10.2.2 双目运算表达式
双目表达式的定义和 C++ 类似，对于含 int 和 bool 类型变量的表达式，要求表达式两边的对象类型必须一致。而表达式两边的值可以是常量或变量。

双目运算表达式支持的运算符为 1. 字符集合 部分标准运算符，关系运算符，逻辑运算符，位运算符。

bool 类型仅可做 == 和 != 运算。

数组对象仅可以和常量 null 进行 == 和 != 运算。

类对象的 == 和 != 运算为比较内存地址，其它运算符重载是未定义的。

字符串的双目运算符参阅字符串部分定义。

10.3. 赋值表达式
语法参考 C++。

由以下方法给出的对象可作为左值被赋值：

函数的形参变量
全局变量和局部变量
类的一个成员
数组对象的一个元素
以下为非法左值，视为语法错误：

this 指针作为左值视为语法错误
常量作为左值视为语法错误
以上定义未涉及的左值是未定义的。

使用赋值表达式的值是未定义的。（欢迎实现类似 C++ 连续赋值的语法）

11. 语句
11.1. 变量声明语句
此处的变量声明不包括类成员变量声明，类成员变量相关请参阅类的定义。

变量声明语句语法如下，支持同时声明多个变量和初始值：

<type> <variableIdentifier1>( = <initializationExpression1>), <variableIdentifier2>( = <initializationExpression2>), ...;

变量在使用之前应已被赋值，访问未初始化赋值的变量是未定义行为。

对于自定义类的对象声明如果没有使用初始化表达式进行赋值，默认值为 null，访问未赋初值的对象（值为 null，保证相关测试仅出现在 Semantic 阶段）。

示例：

class A{
  int a;
};

A a;         // 此时 a 为 null，视为语法正确
int t = a.a; // 语法正确
实例化对象的语法为：<type> <VariableIdentifier> = new <Type>(); 或 <Type> <VariableIdentifier> = new <Type>;，圆括号可以省略。

11.2. 条件语句
条件语句语法如下：

if (<conditionExpression>) {
	<Expressions and Statements if true>
} else {
	<Expressions and Statements if false>
}
其中 <conditionExpression> 表达式值必须为 bool 类型，且该表达式不能缺失，否则为语法错误。

if 语句可以没有 else 部分。若大括号中仅有一个 Expression 或 Statement，则可以省略大括号。

示例:

if (condition) <Expression and Statement if true>
11.3. 循环语句
while 循环语句语法如下：

while (<whileConditionExpression>) {
	<Expressions and Statements if true>
}
<whileConditionExpression> 表达式值必须为 bool 类型，且该表达式不能缺省，否则为语法错误。

for 循环语句语法如下：

for (<initializationStatement>; <forConditionExpression>; <stepExpression>) {
	<Expressions and Statements if true>
}
<initializationStatement>，<forConditionExpression>，<stepExpression> 均可缺省。

<forConditionExpression> 表达式若存在，则值必须为 bool 类型，否则为语法错误。

循环语句若大括号中仅有一个 Expression 或 Statement，则可以省略大括号。

示例：

while (condition) <Expression and Statement if true>
for (init; condition; step) <Expressions and Statements if true>
11.4. 跳转语句
包括 return，break，continue 三种语句，语法如下：

return (<expression>);
break;
continue;
return 语句仅在函数中有效，不在函数中的 return 语句为语法错误。

break 和 continue 语句仅在循环中有效，不在循环中的 break 和 continue 语句为语法错误。

11.5. 表达式语句
表达式语句直接由一个表达式加 ; 组成，此时返回值被丢弃。

形如以下的语句都是合法的：++a; (a); (++a); a + a;

12. 字符串
12.1. 字符串对象
将字符串对象赋值为 null 是语法错误。

12.2. 双目运算
+ 表示字符串拼接

==，!= 比较两个字符串内容是否完全一致（不是内存地址）

<，>，<=，>= 用于比较字典序大小

字符串参与其他双目运算为语法错误，且字符串仅可与相同类型对象进行运算。

12.3. 内建方法
函数：int length();

使用方式：<StringIdentifier>.length();
作用：返回字符串的长度。
函数：string substring(int left, int right);

使用方式：<StringIdentifier>.substring(left, right);
作用：返回下标为[left, right)的子串。
函数：int parseInt();

使用方式：<StringIdentifier>.parseInt();
作用：返回一个整数，这个整数应该是该字符串的最长前缀。如果该字符串没有一个前缀是整数，结果未定义。如果该整数超界，结果也未定义。
函数：int ord(int pos);

使用方式：<StringIdentifier>.ord(pos);
作用：返回字符串中的第pos位上的字符的ASCII码。下标从0开始编号。
常量字符串不具有内建方法，调用常量字符串的内建方法为未定义行为。

13. 作用域
在一段语句中，由 { 和 } 组成的块会引进一个新的作用域
用户定义函数入口会引入一个新的作用域
用户定义类的入口会引入一个新的作用域，该作用域里声明的所有成员，作用域为整个类
全局变量和局部变量不支持前向引用，作用域为声明开始的位置直到最近的一个块的结束位置
函数和类的声明都应该在顶层，作用域为全局，支持前向引用（Forward Reference）
不同作用域的时候，内层作用域可以遮蔽外层作用域的名字
注意：诸如 for 等表达式没有大括号也会引入一个新的作用域，如下：

int a = 0; 
for(;;) int a = 0;
14. 命名空间
在同一个作用域内，变量，函数，和类，都分别不能同名（即变量不能和变量同名，其余同理），如果重名视为语法错误。

在同一个作用域内，变量和函数可以重名，但是类不可以和变量、函数重名。

三、编译说明
1. 程序输入输出
目标程序将通过stdin传入，编译后的程序应当输出到repo根目录下的 output.s 文件，同时将需要链接的 builtin.s 文件也放在 repo 根目录下。

编译要求：

目标汇编：RISC-V 32bit, Integer Extended

gcc构筑命令：./configure --prefix=/opt/riscv --with-arch=rv32ima --with-abi=ilp32

基本的运行阶段：

生成你的编译器 / Build your compiler : 使用系统编译器编译你的编译器代码构建你的编译器的过程。
编译目标代码 / Compile target code : 使用构建的编译器编译Mx*语言，如果编译正确输出目标汇编代码，反之编译器应当以非0返回值退出。
执行目标代码 / Execute target code : 使用模拟器运行你的代码的过程。
2. 评测指标和基准线的划分
评测指标：时间、准确性

时间：采用模拟器运行，计算准确的周期数作为程序运行时间。对于同一个Commit不会重复评测。
准确性：给定输入的情况下，评测输出和程序返回值是否和标准相同。评测输出不会去除行末空格换行符，也不会去除文末换行符
3. FAQ
有任何问题请在这个Repo直接发起Issue，对语言规则有疑问的使用Question标签，发现编译器评测的bug的使用Bug标签，对测试集的问题/发现测试集重的bug的使用benchmark and data/benchmark-URGENT标签。

关于提交：
你需要提交一个repo，且repo的根目录中必须包括：build.bash（类似于makefile中的make all的角色），semantic.bash（类似于g++ -fsyntax-only），codegen.bash（类似于g++ xxx.cpp），optimize.bash（类似于g++ xxx.cpp -O2）。

关于内部已经存储的库：
为了减少git所消耗的时间，所需要的部分依赖库已经集成在Docker中，以下均为绝对路径。

Component	File Name	Path	Language
ANTLR 4.9.1	antlr-4.9.1-complete.jar	/ulib/java/antlr-4.9.1-complete.jar	Java
ANTLR 4.9	antlr-4.9-complete.jar	/ulib/java/antlr-4.9-complete.jar	Java
ANTLR 4.8	antlr-4.8-complete.jar	/ulib/java/antlr-4.8-complete.jar	Java
ANTLR 4.7.2	antlr-4.7.2-complete.jar	/ulib/java/antlr-4.7.2-complete.jar	Java
ANTLR 4.7.1	antlr-4.7.1-complete.jar	/ulib/java/antlr-4.7.1-complete.jar	Java
ANTLR 4.7	antlr-4.7-complete.jar	/ulib/java/antlr-4.7-complete.jar	Java
ANTLR 4.6	antlr-4.6-complete.jar	/ulib/java/antlr-4.6-complete.jar	Java
需要的库请联系TA，放入Docker。

Document Note
全文共三个文章内跳转链接，修改标题名时可能导致链接失效： III.1. / III.8.2 / III.10.2.2