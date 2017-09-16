. 参见:

      http://www.andykhan.com/jexcelapi/download.html       jxl 下载地址  但是现在似乎打不开页面了

      http://jexcelapi.sourceforge.net/    jxl 下载地址

      http://blog.csdn.net/jarvis_java/article/details/4924099    网友关于 poi 与 jxl 的测试对比

      http://wenku.baidu.com/link?url=yD01XLQ9OJD1PF0f8pidRlqWyUWYtrIKXcmphO8ej0tHsVI3NUNaErsEwphL7ZSLqJ1X1ujlb0LDNSJIz0vpSiqsH6Lzf2j0w-TQTY2DWHW

        word、ppt、excel文件格式解析 

      http://www.tuicool.com/articles/qqeUbuv     poi 读取excel 的例子

      http://www.findjar.com/jar/net.sourceforge.jexcelapi/jars/jxl-2.6.jar.html

      http://wenku.baidu.com/view/e373ad0f79563c1ec5da71c8.html  excel 文件格式解析 中英对照

  *   http://wenku.baidu.com/view/b146f3c5aa00b52acfc7ca89.html?re=view      这个是Excel 文件格式正式英文版
   
      http://sc.openoffice.org/excelfileformat.pdf     Excel 文件格式英文版

      https://en.wikipedia.org/wiki/Microsoft_Excel

      http://www.cnblogs.com/rainbowzc/p/3313173.html        这个很好, 推荐， 特别是谈到了<05h>summaryinformat流

. 对于大于1万行的excel 文件, jxl 会内存溢出. 

. 1. 文件格式层级关系

     word、ppt、excel 文档的原理 就像一个文件系统.  文档将数据分成许多流(Streams), 这些流 又存储在不同的仓库(Strorage)里. 流和仓库的命名规则与文件系统相似, 同一个仓库下的流 及 仓库 不能重名, 不同仓库下可以有同名的流. 每个符合文档都有一个根仓库(root storage)。 所有的流又分为更小的数据块, 叫做 数据扇区(sectors). Sectors 可能包含控制数据或用户数据。

  2. 文档头

     文档头在文件的开始, 其大小必定为512字节. 这意味着第一个Sector 的开始相对文件的偏移量为512字节.

     复合文档头的结构如下:

     Offset    size   contents
    
     0         8      复合文档文件标识: D0 CF 11 E0 A1 B1 1A E1

     8         16     此文件的唯一标识(不重要, 可全部为0)

     24        2      文件格式修订号(一般为003E)

     26        2      文件格式版本号(一般为0003)

     28        2      字节顺序规则标识()
     
 
   http://wenku.baidu.com/view/e373ad0f79563c1ec5da71c8.html

. Excel 使用的文件格式叫做 BIFF(二进制文件格式). 这种格式由许多类型的BIFF记录构成, 每个记录都有一个4字节的头, 其中前两个字节是指定记录类型的操作码, 后 两个字节 指定记录的长度. 记录头中的数据值 以低位到高位 形式存储. 除了记录头一歪的字节就是记录的数据. 如下:

    Figure 2-1.  BIFF record header

             |   记录头    | 记录体
    字节编号 |  0  1  2  3 | 0 1 .....
         --------------------
    记录内容 |XX | XX| .....

    --------------------------------
 
             |操作码 |长度 | 数据

. BOF( Beginning of File ) 文件开头

   电子表格的第一个记录总是 BOF

   BOF record

              | Record Header  | Record Body |
      byte       0   1   2   3 | 0  1  2  3  |
     --------------------------------------------
     Contents | 09  00  04  00 | 02 00 10 00 |
     ------------------------------------------
              |操作码 | 长度   |  版本| 文件 | 
              |       |        |  编号| 类型 |

     上面的意思就是:  操作码2个字节，是0009H, 也就是BOF的记录ID; 记录体长度2个字节, 这儿是4字节长.  记录体的头2个字节是版本号(2 是Excel 的初始版本). 后两个字节是文件类型. 10h 标识是电子表格文件。

. 每个复合文件(compound document) 包含一个root storage, 是所有其他storages 和 streams 的直接父节点或间接父节点.

                                  Root Storage

          Storage1        steram1  Stream2      Storage2    stream3   stream4

   stream1                                    stream21  stream22 stream23    


   SecID 负数的情况:

    ---------------------------------------
    SecID  Name                  Meaning
    ----------------------------------
     -1    Free SecID            自由扇区, 可能存在于文件, 但是不属于任何一个stream

     -2    End of chain SecID    SecID 链的结尾

     -3    SAT SecID             SAT 用到的扇区

     -4    MSAT SecID            MSAT 用到的扇区

. 扇区和扇区链

  复合文件的所有stream 分为更小的数据块, 叫做 扇区.  扇区可能包含内部控制数据或者用户数据.

  整个文件包含一个头结构( 复合文件的头, 4.1) 以及后面的一系列扇区。 扇区大小在头部设置.

. 复合文件头的内容 Compound Document Header 

  header 一直在文件的开始, 占用512字节. 这也就是意味着 第一个扇区(SecID 0) 总是从512偏移量开始的。

  headerde 内容如下

  ==========================================================
  偏移量    字节数      内容
  ===========================================================
  0         8         复合文档表示: D0 CF 11 E0 A1 B1 1A E1

  8         16        文件的唯一标识(UID)， 没啥用， 一般全是0

  24        2         文件格式 修订号 ( 通常是 003E )

  26        2         文件格式版本号  ( 通常是 0003 )

  28(0x1C)  2         字节顺序标识        FE FF = Little-Endian    FF FE = Big-Endian

  30(0x1E)  2         复合文件的扇区大小ssz. 2的指数. 实际扇区大小为 2^ssz(最小是7， 也就是2^7 = 128字节)

  32(0x20)  2         短stream 的短扇区的大小sssz, 也是2的指数.实际扇区大小是 2^sssz

  34        10        保留。 没用

  44(0x2C)  4         用于扇区分配表(5.2)的所有扇区数.

  48(0x30)  4         目录stream的第一个扇区 SecID

  52        4         保留。 没用.

  56(0x38)  4         标准stream的最小空间.  通常是4096字节. 小于这个空间的stream 存储在 短stream(short-streams)

  60(0x3C)  4         短扇区分配表的第一个扇区SecID . 如果是-2(FE) 则表示是End of Chain SecID 3.1)

  64(0x40)  4         短扇区分配表的扇区总数

  68(0x44)  4         主扇区分配表的第一个扇区SecID, 如果是-2， 则表示 End of Chain SecID 3.1

  72(0x48)  4         主扇区分配表的扇区总数

  76(0x4C)  436       主扇区分配表的第一部分. 5.1   包含109个扇区ID  SecIDs.    

. 4.2 字节顺序

. 4.3 扇区文件偏移

  sec_pos(SecID) = 512 + SecID* sec_size = 512 + SecID * 2^ssz       ssz 是扇区大小(比如10， 其实是2的10次方)

  例如:  ssz = 10, SecID = 5

  sec_pos(SecID) = 512 + SecID * 2^ssz = 512 + 5 * 2^10 = 512 + 5 * 1024 = 5632

  ## 上面的公式似乎有点问题, 应该是 (SecID-1) * sec_size, 这个才是SecID 对应的扇区的起始位置？？？ 在8.4 中

   SecID 2 对应的位置为0600h, 正好是  512 + （2-1) * 2^10 = 512 + 1024 = 1536 = 0600h
  
      因为在 header 中 SecID 2 是第一个短扇区. 计算公式应该是 512 + SecID * 2^sssz = 512 + 2 * 2^9 = 512 + 2 * 512 = 1536

   问题是在 8.5 中的偏移量计算有不对了， SecID = 10, 但是偏移量是1600h=512 + 5*1024, 而不是2600h = 512 + (10-1)*1024 

      同上面的计算，  512 + 10 * 2 ^ 9 = 512 + 10 * 512 = 5632

   所以计算扇区便宜量， 首先要确认是短扇区， 还是标准扇区。 

 
. 5. 扇区分配

. 5.1 主扇区分配表 MSAT

  MSAT 是一个SecIDs 的数组。  MSAT 的前109个SecIDs 存放在 Header, 如果MSAT 包含超过109个SecIDs, 增加第一个扇区来存放后续的SecIDs.  Header 包含第一个扇区的SecIDs 提供给MSAT 使用, 其他情况下 是-2， 表示End of Chain SecID.

  MSAT 的每个扇区的最后一个SecID 指向下一个扇区.  如果没有后续的扇区, 最后一个SecID = -1, 表示End of Chain SecID.

  MSAT 的扇区内容

  -----------------------------
  Offset         Size             Contents
  ------------------------------
    0           sec_size - 4      Array of (sec_size-4)/4 SecIDs of the MSAT

  sec_size-4    4                 SecID of the next sector used for the MSAT, or -2 if this is the last sector.

  -------------------------------

  MSAT 的最后一个扇区可能不会被完全使用。 没有使用的空间用 -1填充, 表示指定的Free SecID.  MSAT 由 Header 中的 SecIDs 和附加的MSAT 扇区构成. 

  例如: 一个复合文档文件 包含一个SAT ，需要300个需要存储的扇区.  header 指定一个扇区大小是512字节. 这意味着一个扇区可以存储128个SecIDs.  MSAT 包含300 个SecIDs( 用于SAT的扇区数量). 前109个SecIDs 存放在Header. 剩下的191个SecIDs 需要额外的2个扇区.   在这个例子中, MSAT的第一个扇区可能是扇区1包含MSAT后续的127个SecIDs( 第128个SecID 指向的是下一个MSAT扇区), 第二个MSAT 扇区 存放剩下的64个SecIDs. (127+64 = 191)

  HEADER            SecID of first sector of the MSAT = 1
                           |
  SECTOR 0                 |
                          \|/
  SECTOR 1          SecID of the next sector of the MSAT (last SecID in this sector ) = 6

  SECTOR 2

  SECTOR 3

  SECTOR 4

  SECTOR 5

  SECTOR 6          SecID of next sector of the MSAT (last SecID in this sector ) = -2

  ...

.短流 Short-Stream

 只要一个stream 长度小于指定的长度(header中指定), 就会被存储为short-stream. Short-Stream 不直接用扇区存储数据, 全都被嵌入指定的内部控制流(specific internal stream), short-stream container stream.(容器流)

. Short-stream Container Stream    短流容器流

  short-stream container stream 像其他用户stream (long) 一样存储。  第一个用到的扇区必须是从root storage (7.2)入口获得.  它的SecID 链 在SAT中包含. 

  short-stream container stream 用到的所有扇区数据 是SecID 链来关联。  下一步, 这个stream 虚拟拆分为short-sectors, 类似于主复合文件的扇区， 不过就是没有header 结构。 当然, 第一个短扇区(short-secotr)(SecID 0) 通常在short-stream container stream 的偏移量为0.   short-sector 的大小在header 中定义。  用这个信息可以通过SecID计算出short-stream 在 short-stream container stream 中的偏移量

  short_sec_pos(SecID) = SecID * short_sec_size = SecID * 2 ^ sssz

  例如:   sssz = 6 , SecID = 5

  short_sec_pos(SecID) = SecID * 2 ^ sssz = 5 * 2 ^ 6 = 5 * 64 = 320

. SSAT (Short-Sector Allocation Table )

  SSAT 是一个SecIDs 的数组。 包含所有short-stream 的SecID链,  类似于SAT 包含标准stream的SecID 链. 

  SSAT的第一个SecID 在header中定义.  剩余的SecID 链在SAT中. SSAT 是通过读取 并连接 扇区信息来构建的.

  SSAT的内容 (sec_size 是扇区的字节大小 4.1 )

  ------------------------------------
  Offset    Size      Contents
  ------------------------------------
  0        sec_size   Array of sec_size/4 SecIDs of the SSAT
  ------------------------------------

. 7. 目录 Directory 

. 7.1 目录结构

  directory 是内部控制流. 由目录入口(directory entries)组成.  每一个目录入口指向一个storage 或一个stream.  目录入口按它们在stream的顺序排列.  索引为0 的目录入口 称为 目录入口ID ( DirID)

    -----------------------------
    Directory Entry 0

    Directory Entry 1
 
    Directory Entry 2

    Directory Entry 3

    ....

    -------------------------------

    目录入口与storage 或 stream在 复合文件中存在时间一致。 如果storage 或 stream 移除了, 对应的 目录入口也会被置空。 DirID 0 是比较特殊的, 是目录的开始, 它代表root stroage ， 称为 root storage entry.

    目录入口 用 红黑树 来组织每一个storage的直接成员(storage和stream).  red-black tree.  用来描述 storage 或 stream  之间的关系.   

    简单的说, 红黑树中的节点 必须达到一些的条件:

        1. root 节点是 black  黑

        2. 红节点的父节点 是 black

        3. 从root 到 叶子之间的路径 包括相同数量的黑节点

        4. 左边的孩子节点 少于 右边的孩子节点.

    但是需要注意的是, 不是所有的实现是遵从这些规则. 最安全的方式是读取Directory Entry， 忽略节点颜色, 重构红黑树.

   每个目录入口包含3个DirIDs: 左孩子DirID 包含的是红黑树的左孩子入口,  右孩子 是红黑树的右孩子。 第三个DirID 是包含所有子 stream 和 子 storage 的红黑树的根节点的DirID. 

  注意， 通过entry名称的长度也可以判断左右孩子, 短的是左， 长的是右.

. 7.2 目录入口

  
. 7.2.1  目录入口结构

   每一个目录入口都是精确的128字节.  这种格式是为了通过DirIDs 来计算 其在 目录流中的偏移量.

   dir_entry_pos(DirID) = DirID * 128

   目录入口结构的 内容描述: (-1 = 0xFFFFFFFF)

   ------------------------------------
   Offset     Size     Contents
   ------------------------------------
     0         64       字符串. 入口名称. 通常是16位Unicode 字符串。尾0结束(实际名称最大只能有31个字符)

     64        2        名称的字符缓冲大小. 包括尾0.  例如: 5个字符的名字: (5+1) * 2 = 12 字节

     66        1        入口类型.  00h = 空                 01h = User Stroage      02h = User stream 
                                   03h = LockBytes(unknown) 04h=Property(unknown)   05h = Root storage

     67        1        入口的节点颜色.   00h = Red       01h = Black

     68        4        red-black tree 左边子节点的DirID(如果入口是User storage 或 stream), -1 表示没有左面子节点.

     72        4        red-black tree 右边子节点的DirID(如果入口是User storage 或 stream), -1 表示没有右面子节点.

     76        4        所有storage 成员在 red-black tree  中的root 节点的DirID. -1 其他情况.

     80        16       UID, 如果是一个storage 的话才有， 可能全部为0

     96        4        User flags (对下面的内容而言可能无用,  可能全部为0)

    100        8        创建这个入口的时间戳. 通常都不写合法时间, 而是都写0.

    108        8        修改这个入口的时间戳.  通常都不写合法时间, 而是都写0

    116        4        扇区或短扇区的第一个SecID。 如果这个入口指向一个stream，就是short-stream container stream 
                        的第一个扇区SecID; 如果是root storage 入口, 0. 其他情况

    120        4        所有的stream 的字节大小.如果这个入口指向一个stream,就是short-stream container stream的整个字节数
                        如果是root storage 入口, 0 

    124        4        Not Used
   ----------------------------------------------

   *** 很重要, 处理Excel 就是从Directory 的Entry 来开始处理的。 

. 8. 例子                         


. 8.2. 主扇区分配表  MSAT

   header 包含整个MSAT, 这儿也 没啥东西。 MSAT 是由 SecID 链组成。

. 8.3 SAT  扇区分配表

  为了构建SAT, MSAT 中的所有扇区都必须能读取到.下面的例子只有扇区0.开始于文件偏移量0000 0200H = 512 , 如下(略，参见原文)  

. 8.4 SSAT  短扇区分配表

. 8.5 目录

  ------------------------------------华丽的分割线 -------------------


. 

. Excel 文件结构

. 2.3.1 流文件

  所有文件类型和BIFF 版本可以存储在一个简单的流文件中, 大部分都是这种存储方式. 有一个例外, BIFF5-BIFF8 workbook 文档, 它存储在复合文档.  如果这些文档作为流文件存储, 那么整个文件就是"Book"流(BIFF5) 或 "Workbook"流(BIFF8) 组成.

. 2.3.2 复合文档文件(BIFF5-BIFF8)  Compound Document File

  一个有几个sheets(BIFF5-BIFF8)的workbook 文档， 通常存储为复合文档文件格式(也叫做"OLE2 storage file format" 或者 "Microsoft Office compatible storage file format"). 它包含几个streams 对应不同类型的数据.  compound document 参见相关文档

  下面是可能的流stream

  -------------------------------
  Stream name                             Contents
  -------------------------------
  Book                                    BIFF5 Workbook Stream  (2.3.3)
  
  Workbook                                BIFF8 Workbook Stream( 2.3.3)

  <05H>SummaryInformation                 Document Settings

  <05H>DocumentSummaryInformation         Document settings

  Ctls                                    Formatting of form controls

  User Name                               User names in shared workbooks (9)

  Revision Log                            change tracking log stream(9)
  ----------------------------------

  也可以向文件系统的子目录一样创建substorages, 例如 PivotTable stream.  这些 storage 自身 包含 substreams

  ------------------
  Storage name                 contents
  --------------------
  LNKxxxxxxxx                  Storage for a linked OLE object (6)

  MDBxxxxxxxx                  Storage for an embedded OLE object(6)

  _SX_DB_CUR                   Pivot cache storage. 这个streams 包含缓冲区 PivotTables(8) 

  _VBA_PROJECT_CUR             Visual BASIC project storage
  -------------------------


. 2.3.3 Worksheet/Workbook/Workspace Stream

  Worksheet Stream 在4.1.1 中详细描述.

  Workbook Stream 在4.1.2 中详细描述

  Workspace Stream 在10 中详细描述

. 2.3.4 Substreams

  BIFF5-BIFF8 Workbook stream 分为几部分来描述 workbook global 和 包含的sheets(表单)(2.1.3). 每一部分叫做一个substream. 在stream 中定义了开始和结束位置.

  定义: Workbook Globals Substream

      这个substream 包含workbook 的 global information. 叫做 Workbook Globals Substreams. 是 Workbook Stream 的一部分.

  定义: Sheet Substream

    
. 2.4 BIFF 记录结构  ---- BIFF Record      P16

   大部分 Excel 的stream或 substream 都是拆分为records 来描述的.  每个记录都有不同的数据.  它包含头部来制定记录类型和大小, 后面的就是记录的数据

   普通的BIFF 记录结构为

   ---------------------------
   Offset       Size         Contents
   ------------------------------------
   0            2            Identifier                                  }
                                                                         }   记录头
   2            2            Size of the following data(sz)              }
  ---------------------------------------------------------

   4            sz           Record data
  --------------------------------------------------

  记录数据的最大长度依赖于 BIFF的版本.  .。。。。有continue....

  通常记录数据的offset 是相对于本记录的开始, 而不是所有记录的开始. 

   


. 4. Worksheet/Workbook Stream     P79

  Excel 文档的复杂内容拆分为几条记录.  为了保持Worksheet/Workbook Stream 一致， 记录的位置和顺序非常重要. 本章就详细介绍stream 中的记录.  记录的内部结构参见第5章.

.4.1.1. Worksheet Stream (BIFF2-BIFF4)

 Worksheet Stream (BIFF2-BIFF4)中的记录:

     BOF                         Type = sheet , chart, macro sheet (5.8   p135)

     EOF                         5.37   ( ?? 没有这一节) 不过查看ID 应该是 000AH  对应文档应该是 0A 00

. 4.1.2 Workbook Stream (BIFF5-BIFF8)

  通常结构为:

   .   Workbook Globals Substreams

   ..  Sheet Substreams

  Workbook Stream 中的记录为: BIFF5-BIFF8

   .  BOF  Type = workbook globals (5.8  )

   .  EOF  5.37

   ..      . BOF     Type = sheet, chart, macro sheet, Basic module, ... ( 5.8 )

           .. EOF    5.37

. 4.2  Streams 和 Substreams  中的记录顺序

. 4.2.5 Record Order in a BIFF8 Workbook Stream  **********************  这个是非常关键的一节， 说明了第一个stream 的结构

  Workbook Globals Substream:    P85

    ---------------------------------------------

    BOF                  Type = workbook globals (5.8  p135)
    
       File Protection Block           -> 4.19        P 117

       CODEPAGE                        -> 5.17        P145      0042h

       DSF                             -> 5.36        P161    0161h

       TABID

       FNGROUPCOUNT

       Workbook Protection Block      -> 4.18         P114    4.18.3  P115   

             WINDWOPROTECT          5.111      0019h    p217

             PROTECT                5.82      0012h   P200

             PASSWORD               5.76        0013h   P197

             PROT4REV               是否密码保护

             PROT4REVPASS           密码信息

   WINDOW1                            -> 5.109            003Dh    P215

       BACKUP                         -> 5.5              0040h    P133

       HIDEOBJ                        -> 5.56             008Dh    P181   

       DATEMODE                       -> 5.28             0022h    P154  

       PRECISION                      -> 5.79             000Eh    P198

       REFRESHALL

       BOOKBOOL                       -> 5.9              00DAh     P137
 
  .. FONT                             -> 5.45             0031h     P171

       FORMAT                         -> 5.49             041Eh     P174

  .. XF                               -> 5.115            00E0h     P219     扩展格式

  ... STYLE                           -> 5.103             0293h    P212

      PALETTE                         -> 5.74              0092h    P195

      USESELFTS                       -> 5.106             0160h    P213

  ... SHEET                           -> 5.95              0085h    P206

      COUNTRY                         -> 5.22           0022h     P149

      Link Table                      -> 4.10.3      P105

      DEFINEDNAME                     -> 5.33            0018h     P157       

      Shared String Table             -> 4.11          00FCh    P110      SST    5.100  P210

  . EOF                               -> 5.37      P161   000Ah


  ## File Protection Block    4.19  P117

    文件的写保护/读写保护等密码信息

    结构为:

       WRITEPROT         密码在 FILESHARING   5.113      P218     0086h

       FILEPASS          读写保护, 验证信息  5.43       P168     002Fh(ID)

       WRITEACCESS       用户名   5.112            P218   005Ch

               offset      size      contents
                0           var       user name, byte string, 16-bit string length, 109 characters   2.5.3

       FILESHARING       File sharing options   5.44          005Bh      P 170

   File Protection Block 记录是文件的第一个记录.  4.2    P81

   ### SHEET 记录很关键  0085h   5.95 P 206

   该记录在Workbook Globals Substream ， 代表 workbook里面的一个表单(sheet). 一条SHEET 记录对应一个sheet. 它保存sheet 的名称, 以及一个stream 到BOF 记录的 偏移量. 也就是 Sheet SubStream 在 Workbook Stream 的偏移量. 

    -----------------------------------
    Offset        Size     Contents
    -------------------------------------
     0            4        这条记录对应的表单的BOF记录的绝对stream 位置。 这个字段即便是文件保护了也不进行加密。

     4            1        表单状态    0 可见  1  隐藏  2 Very hidden(程序设置， 脚本？)

     5            1        表单类型    00h  Worksheet  02h chart  06h VB module

     6            var      表单名称    BIFF8: Unicode String, 8位字符串长度  2.5.3 (P17)

     
   ====
   Unicode String  (2.5.3 P17)

   ----------------
   Offset      Size         contents
   ---------------
   0           1 or 2       字符串长度(按字符计算)    (按2字节来计算吧。。。。)

   1 or 2      1            可选flags

                            -----------------------
                            Bit     Mask      contents
                            ------------------------
                             0      01h       字符压缩(ccompr)  0   8位字符压缩， 1 16为字符压缩

                             2      04h       亚洲电话设置(phonetic) 0 不包含亚洲电话设置， 1 包含亚洲电话设置

                             3      08h       Rich-Text 设置(richtext) 0 不包含Rich-text设置,  1 包含
                            --------------------------
   [2 or 3]      2         可选(richtext =1 才有) Richtext的个数 rt。

   [var]           4         可选。phonetic=1   亚洲电话设置块 大小  sz.

   var      ln or 2 * ln    字符数组. 8位或16位, 依赖于ccompr    

   [var.]       4*rt        2.5.1   richtext ==1 。 rt 格式列表

   [var.]       sz          if phonetic == 1.  亚洲电话设置块

   ######################

   --------------SST -----------  5.100   P210
    Offset     Size     Contents
   -----------------------------
     0         4         workbook 中的字符串数量 Total 

     4         4         下面的字符串个数(nm)

     8         var       nm Unicode字符串列表, 16位字符串长度   2.5.3
    -----------------------------------------------------
        
   --------------CONTINUE   5.21  P148  003Ch-----------
    BIFF8 8224 bytes (8228 bytes including record header)

    Offset     Size     Contents
   -----------------------------
    0          var.      Data continuation of the previous record
    -----------------------------------------------------
        

   ============

   Sheet subStream

   BOF                              Type = sheet (5.8)

      INDEX                         4.7(Row Blocks  P90) -> 5.59 P185

      Calculation settings block    4.3

      PRINTHEADERS                  5.81

      PRINTGRIDLINES                5.80

      GRIDSET                       5.52

      GUTS                          5.53
      
      --------Cell Table begin --

      DEFAULTROWHEIGHT              5.31

      SHEETPR                       5.97

      pages settings block          4.4

      Worksheet Protection block    4.18

      DEFCOLWIDTH                   5.32

      COLINFO                       5.18      007Dh   P146

      SORT                          5.99

      DIMENSION                     5.35

      Row Blocks                    4.7   P90

      Worksheet view Setting block  4.5

      STANDARDWIDTH                 5.101

     -----------Cell Table end -----

      MERGEDCELLS                   5.67

      LABELRANGES                   5.64

      PHONETICPR                    5.77

      Conditional Formatting Table  4.12

      Hyperlink Table               4.13

      Data Validity Table           4.14

      SHEETLAYOUT                   5.96

      SHEETPROTECTION               Additional protection -> 5.98

      RANGEPROTECTION               Additional protection -> 5.84

  EOF                               5.37


. COLINFO     5.18  P146

  first last   宽度   XF     flags   没用
  0000  0000   6008   3E00   0600    0200

  A600  A600   A012   3E00   0600    0200       00A6  = 166
 
  A700  0001   0009   3E00   0000    0200       00A7  = 167     Last < first 说明col 结束了

  对于数据处理而言, 这条记录可以忽略。



. DIMENSION      5.35  P160
 
  first Row       last  Row      first col    last col    没用
  00000000        F0290000       0000         A700        0000

  29F0 = 10736  也就是 Excel 实际行数

  00A7 = 167  也就是实际列数

  第0行和第0列都是系统自用了， 用来表示下标  A1, B2之类的

  处理数据的时候, 这个也很重要. 可以提前判断有多少行， 多少列。 


. ROW  记录    5.88  P202   

  row     first col   last col   高度     没用     没用       flag, 格式
  0000    0000        A700       0E01     0000     0000       00010F00

  5F28    0000        A700       0E01     0000     0000       00010F00

  对于数据处理而言, 这条记录可以忽略。

. DBCELL    5.29   P155   00D7h

  Row 块中出现一次.  用来记录下面的Row 相对第一条Row 的相对位置。 主要是Row 记录可能不是全部在一起。

  如果是处理数据的话, 这条记录也可以忽略。   


. LABELSST    5.65  P188                    ****** 这个 SST  是获取内容的关键。。。

  单元格的字符串.
  -----------------------------------
  Offset    Size       Contents
  ------------------------------------
  0         2          行索引

  2         2          列索引

  4         2          XF 记录索引  XF  5.115->   P219

  6         4          SST 记录索引  5.100     ->P210
 --------------------------------------------


  例如:
      0000  0000  3F00    A35C0200    

      3F00 -> 0x3F -> 63 

      A35C0200 -> 0x25CA3 = 154787    -> 对应 SST 的内容就是"病案号"  SST[154787] = "病案号"

      EF29 A600 4000  565D0200

      EF29 -> 29EF = 29F0-1 = 10735  (应为单元格下标是从0开始, 实际对应的是10736行)

      A600->00A6 = 166    对应 166列

      565D0200 -> 0x025D56 = 154966  -> SST[154966] = "44.00"  ？？  这个不对, 应该是空格呀？？

. <05H>SummaryInformation 流的格式

 0-27(00h-1Bh)       28字节       <05H>SummaryInformation 流的头部, 含义如下

     0-1             2             16位整数, 字节排序方式

     2-3             2             16位整数, 用于验证流.  一般没用, 通常为0

     4-5             2             操作系统版本号, 前一个字节表示主版本, 后一个字节表示次版本. 对于Windows xp, 为"05 01"

     6-7             2             16为整数, 操作系统,  2: win32, 1: mac,  0: win16

     8-23(08h-17h)   16            流的类编码(the stream's class id)， 格式为: dword + 2 words + 2bytes + 6 bytes 
                                   dword 是32位整数, word 是16位整数, byte 是8位整数, 值为:
                                   "00000000-0000-0000-0000-000000000000"
  
    24-27(18h-1bh)   4             32位整数, 表示流中 节的个数(section)，通常<05h>SummaryInformation流只有1节, 该值总是1

  紧接着头部的是 节声明, 共 20个字节, 2个字段

    28-43(1Ch-2Bh)   16            节的类编码(section's class id), 对于<05h>SummaryInformation 流， 该值为
                                   "f29f85e0-4ff9-1068-ab91-08002b27b3d9"   

    44-47(2Ch-2Fh)   4             32位整数, 表示节数据 相对于 流起始位置的偏移量. 值通常为48(30h)   

    节头部, 在示例中, 节的偏移量为48(30h)， 节头部共8个字节, 有2个字段, 在节中:

    0-3              4             (示例中, 对应流偏移量为48-51即 30h-33h，下同)，32位整数, 表示节尺寸.

    4-7              4              32位整数, 表述属性个数

   紧接着节头部, 是若干(按属性个数, 示例中为8个)个属性声明, 属性声明由两个32位整数构成, 前者为属性编码(ID), 后者为属性数据相对于节起始位置的偏移量。

   对于<05h>SummaryInformation 流, 属性编码(ID)极其含义如下:

       ----------------------------
       属性编码ID          含义               属性类型(下面有介绍, 不同的类型后面的数据格式不同)
       -----------------------------------------------
       1(01h)              代码页             2(02h)

       2(02h)              标题               30(1Eh)

       3(03h)              主题               30(1Eh)

       4(04h)              作者               30(1Eh)

       5(05h)              关键字             30(1Eh)

       6(06h)              备注               30(1Eh)

       7(07h)              模板               30(1Eh)

       8(08h)              最后保存           30(1Eh)

       9(09h)              修正号             30(1Eh)

       10(0Ah)             总编辑时间         64(40h)

       11(0Bh)             最后打印时间       64(40h)

       12(0Ch)             创建时间           64(40h)

       13(0Dh)             最后保存时间       64(40h)

       14(0Eh)             页数               3(03h)

       15(0Fh)             字数               3(03h)

       16(10h)             字符数             3(03h)

       17(11h)             缩略图             71(47h)

       18(12h)             创建文档的程序名称 30(1Eh)

       19(13h)             安全               3(03h)

   属性数据的长度不是固定的, 它跟属性类型有关, 属性数据的第一个32位整数表示属性类型, 紧接其后的就是属性的值, 属性类型极其含义如下:

      -----------------------------
       属性类型         含义
      -----------------------------
       2(02)           16位带符号整数

       3(03)           32位带符号整数

       19(13h)         32位无符号整数

       30(1Eh)         字符串 ( 格式: 32位 整数表示长度 + 0结尾的字符串)

       64(40h)         时间戳

       71(47h)         剪贴板格式
      ------------------------------------

  其结构与“<05H>SummaryInformation”流类似，所不同的是节的类编码（section's class id）的值为“d5cdd502-2e9c-101b-9397-08002b2cf9ae”。

<05H>DocumentSummaryInformation”流中主要储存与文件类型有关的属性，因此，根据不同类型的文件，在属性编码及属性类型上做了一些扩展，这里就不再一一介绍了。


. 5.8 BOF --- Beginning of File

   -------------------------------------
   BIFF2    BIFF3     BIFF4       BIFF5      BIFF8
   -----------------------------------------------
   0009h    0209h     0409h       0809h       0809h
   -------------------------------------------------
. 5.81  Excel 写的 BOF 记录

  BIFF5    0809h
  ---------------------
  offset      size    contents
  --------------------------
   0          2        BIFF 版本(BIFF5 通常是0500h). 如果是workbook

   2          2        后面数据的类型.  0005h = Workbook globals  
                                        0006h = Visual Basic module
                                        0010h = Sheet or dialogue (see SHEETPR, 5.97)
                                        0020h = Chart
                                        0040h = Macro sheet
                                        0100h = Workspace(BIFF5W only)

   4          2        Build identifier . 不能为0

   6          2        Build year
  --------------------------------------------

  BIFF8    0809h
  ---------------------
  offset      size    contents
  --------------------------
   0          2        BIFF 版本(BIFF8 通常是0600h). 如果是workbook

   2          2        后面数据的类型.  0005h = Workbook globals  
                                        0006h = Visual Basic module
                                        0010h = Sheet or dialogue (see SHEETPR, 5.97)
                                        0020h = Chart
                                        0040h = Macro sheet
                                        0100h = Workspace(BIFF5W only)

   4          2        Build identifier . 不能为0

   6          2        Build year. 不能为0

   8          4        文件历史flags

  12          4        能读取该文件的最低Excel 版本
  --------------------------------------------
