. �μ�:

      http://www.andykhan.com/jexcelapi/download.html       jxl ���ص�ַ  ���������ƺ��򲻿�ҳ����

      http://jexcelapi.sourceforge.net/    jxl ���ص�ַ

      http://blog.csdn.net/jarvis_java/article/details/4924099    ���ѹ��� poi �� jxl �Ĳ��ԶԱ�

      http://wenku.baidu.com/link?url=yD01XLQ9OJD1PF0f8pidRlqWyUWYtrIKXcmphO8ej0tHsVI3NUNaErsEwphL7ZSLqJ1X1ujlb0LDNSJIz0vpSiqsH6Lzf2j0w-TQTY2DWHW

        word��ppt��excel�ļ���ʽ���� 

      http://www.tuicool.com/articles/qqeUbuv     poi ��ȡexcel ������

      http://www.findjar.com/jar/net.sourceforge.jexcelapi/jars/jxl-2.6.jar.html

      http://wenku.baidu.com/view/e373ad0f79563c1ec5da71c8.html  excel �ļ���ʽ���� ��Ӣ����

  *   http://wenku.baidu.com/view/b146f3c5aa00b52acfc7ca89.html?re=view      �����Excel �ļ���ʽ��ʽӢ�İ�
   
      http://sc.openoffice.org/excelfileformat.pdf     Excel �ļ���ʽӢ�İ�

      https://en.wikipedia.org/wiki/Microsoft_Excel

      http://www.cnblogs.com/rainbowzc/p/3313173.html        ����ܺ�, �Ƽ��� �ر���̸����<05h>summaryinformat��

. ���ڴ���1���е�excel �ļ�, jxl ���ڴ����. 

. 1. �ļ���ʽ�㼶��ϵ

     word��ppt��excel �ĵ���ԭ�� ����һ���ļ�ϵͳ.  �ĵ������ݷֳ������(Streams), ��Щ�� �ִ洢�ڲ�ͬ�Ĳֿ�(Strorage)��. ���Ͳֿ�������������ļ�ϵͳ����, ͬһ���ֿ��µ��� �� �ֿ� ��������, ��ͬ�ֿ��¿�����ͬ������. ÿ�������ĵ�����һ�����ֿ�(root storage)�� ���е����ַ�Ϊ��С�����ݿ�, ���� ��������(sectors). Sectors ���ܰ����������ݻ��û����ݡ�

  2. �ĵ�ͷ

     �ĵ�ͷ���ļ��Ŀ�ʼ, ���С�ض�Ϊ512�ֽ�. ����ζ�ŵ�һ��Sector �Ŀ�ʼ����ļ���ƫ����Ϊ512�ֽ�.

     �����ĵ�ͷ�Ľṹ����:

     Offset    size   contents
    
     0         8      �����ĵ��ļ���ʶ: D0 CF 11 E0 A1 B1 1A E1

     8         16     ���ļ���Ψһ��ʶ(����Ҫ, ��ȫ��Ϊ0)

     24        2      �ļ���ʽ�޶���(һ��Ϊ003E)

     26        2      �ļ���ʽ�汾��(һ��Ϊ0003)

     28        2      �ֽ�˳������ʶ()
     
 
   http://wenku.baidu.com/view/e373ad0f79563c1ec5da71c8.html

. Excel ʹ�õ��ļ���ʽ���� BIFF(�������ļ���ʽ). ���ָ�ʽ��������͵�BIFF��¼����, ÿ����¼����һ��4�ֽڵ�ͷ, ����ǰ�����ֽ���ָ����¼���͵Ĳ�����, �� �����ֽ� ָ����¼�ĳ���. ��¼ͷ�е�����ֵ �Ե�λ����λ ��ʽ�洢. ���˼�¼ͷһ����ֽھ��Ǽ�¼������. ����:

    Figure 2-1.  BIFF record header

             |   ��¼ͷ    | ��¼��
    �ֽڱ�� |  0  1  2  3 | 0 1 .....
         --------------------
    ��¼���� |XX | XX| .....

    --------------------------------
 
             |������ |���� | ����

. BOF( Beginning of File ) �ļ���ͷ

   ���ӱ��ĵ�һ����¼���� BOF

   BOF record

              | Record Header  | Record Body |
      byte       0   1   2   3 | 0  1  2  3  |
     --------------------------------------------
     Contents | 09  00  04  00 | 02 00 10 00 |
     ------------------------------------------
              |������ | ����   |  �汾| �ļ� | 
              |       |        |  ���| ���� |

     �������˼����:  ������2���ֽڣ���0009H, Ҳ����BOF�ļ�¼ID; ��¼�峤��2���ֽ�, �����4�ֽڳ�.  ��¼���ͷ2���ֽ��ǰ汾��(2 ��Excel �ĳ�ʼ�汾). �������ֽ����ļ�����. 10h ��ʶ�ǵ��ӱ���ļ���

. ÿ�������ļ�(compound document) ����һ��root storage, ����������storages �� streams ��ֱ�Ӹ��ڵ���Ӹ��ڵ�.

                                  Root Storage

          Storage1        steram1  Stream2      Storage2    stream3   stream4

   stream1                                    stream21  stream22 stream23    


   SecID ���������:

    ---------------------------------------
    SecID  Name                  Meaning
    ----------------------------------
     -1    Free SecID            ��������, ���ܴ������ļ�, ���ǲ������κ�һ��stream

     -2    End of chain SecID    SecID ���Ľ�β

     -3    SAT SecID             SAT �õ�������

     -4    MSAT SecID            MSAT �õ�������

. ������������

  �����ļ�������stream ��Ϊ��С�����ݿ�, ���� ����.  �������ܰ����ڲ��������ݻ����û�����.

  �����ļ�����һ��ͷ�ṹ( �����ļ���ͷ, 4.1) �Լ������һϵ�������� ������С��ͷ������.

. �����ļ�ͷ������ Compound Document Header 

  header һֱ���ļ��Ŀ�ʼ, ռ��512�ֽ�. ��Ҳ������ζ�� ��һ������(SecID 0) ���Ǵ�512ƫ������ʼ�ġ�

  headerde ��������

  ==========================================================
  ƫ����    �ֽ���      ����
  ===========================================================
  0         8         �����ĵ���ʾ: D0 CF 11 E0 A1 B1 1A E1

  8         16        �ļ���Ψһ��ʶ(UID)�� ûɶ�ã� һ��ȫ��0

  24        2         �ļ���ʽ �޶��� ( ͨ���� 003E )

  26        2         �ļ���ʽ�汾��  ( ͨ���� 0003 )

  28(0x1C)  2         �ֽ�˳���ʶ        FE FF = Little-Endian    FF FE = Big-Endian

  30(0x1E)  2         �����ļ���������Сssz. 2��ָ��. ʵ��������СΪ 2^ssz(��С��7�� Ҳ����2^7 = 128�ֽ�)

  32(0x20)  2         ��stream �Ķ������Ĵ�Сsssz, Ҳ��2��ָ��.ʵ��������С�� 2^sssz

  34        10        ������ û��

  44(0x2C)  4         �������������(5.2)������������.

  48(0x30)  4         Ŀ¼stream�ĵ�һ������ SecID

  52        4         ������ û��.

  56(0x38)  4         ��׼stream����С�ռ�.  ͨ����4096�ֽ�. С������ռ��stream �洢�� ��stream(short-streams)

  60(0x3C)  4         �����������ĵ�һ������SecID . �����-2(FE) ���ʾ��End of Chain SecID 3.1)

  64(0x40)  4         ��������������������

  68(0x44)  4         �����������ĵ�һ������SecID, �����-2�� ���ʾ End of Chain SecID 3.1

  72(0x48)  4         ��������������������

  76(0x4C)  436       �����������ĵ�һ����. 5.1   ����109������ID  SecIDs.    

. 4.2 �ֽ�˳��

. 4.3 �����ļ�ƫ��

  sec_pos(SecID) = 512 + SecID* sec_size = 512 + SecID * 2^ssz       ssz ��������С(����10�� ��ʵ��2��10�η�)

  ����:  ssz = 10, SecID = 5

  sec_pos(SecID) = 512 + SecID * 2^ssz = 512 + 5 * 2^10 = 512 + 5 * 1024 = 5632

  ## ����Ĺ�ʽ�ƺ��е�����, Ӧ���� (SecID-1) * sec_size, �������SecID ��Ӧ����������ʼλ�ã����� ��8.4 ��

   SecID 2 ��Ӧ��λ��Ϊ0600h, ������  512 + ��2-1) * 2^10 = 512 + 1024 = 1536 = 0600h
  
      ��Ϊ�� header �� SecID 2 �ǵ�һ��������. ���㹫ʽӦ���� 512 + SecID * 2^sssz = 512 + 2 * 2^9 = 512 + 2 * 512 = 1536

   �������� 8.5 �е�ƫ���������в����ˣ� SecID = 10, ����ƫ������1600h=512 + 5*1024, ������2600h = 512 + (10-1)*1024 

      ͬ����ļ��㣬  512 + 10 * 2 ^ 9 = 512 + 10 * 512 = 5632

   ���Լ��������������� ����Ҫȷ���Ƕ������� ���Ǳ�׼������ 

 
. 5. ��������

. 5.1 ����������� MSAT

  MSAT ��һ��SecIDs �����顣  MSAT ��ǰ109��SecIDs ����� Header, ���MSAT ��������109��SecIDs, ���ӵ�һ����������ź�����SecIDs.  Header ������һ��������SecIDs �ṩ��MSAT ʹ��, ��������� ��-2�� ��ʾEnd of Chain SecID.

  MSAT ��ÿ�����������һ��SecID ָ����һ������.  ���û�к���������, ���һ��SecID = -1, ��ʾEnd of Chain SecID.

  MSAT ����������

  -----------------------------
  Offset         Size             Contents
  ------------------------------
    0           sec_size - 4      Array of (sec_size-4)/4 SecIDs of the MSAT

  sec_size-4    4                 SecID of the next sector used for the MSAT, or -2 if this is the last sector.

  -------------------------------

  MSAT �����һ���������ܲ��ᱻ��ȫʹ�á� û��ʹ�õĿռ��� -1���, ��ʾָ����Free SecID.  MSAT �� Header �е� SecIDs �͸��ӵ�MSAT ��������. 

  ����: һ�������ĵ��ļ� ����һ��SAT ����Ҫ300����Ҫ�洢������.  header ָ��һ��������С��512�ֽ�. ����ζ��һ���������Դ洢128��SecIDs.  MSAT ����300 ��SecIDs( ����SAT����������). ǰ109��SecIDs �����Header. ʣ�µ�191��SecIDs ��Ҫ�����2������.   �����������, MSAT�ĵ�һ����������������1����MSAT������127��SecIDs( ��128��SecID ָ�������һ��MSAT����), �ڶ���MSAT ���� ���ʣ�µ�64��SecIDs. (127+64 = 191)

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

.���� Short-Stream

 ֻҪһ��stream ����С��ָ���ĳ���(header��ָ��), �ͻᱻ�洢Ϊshort-stream. Short-Stream ��ֱ���������洢����, ȫ����Ƕ��ָ�����ڲ�������(specific internal stream), short-stream container stream.(������)

. Short-stream Container Stream    ����������

  short-stream container stream �������û�stream (long) һ���洢��  ��һ���õ������������Ǵ�root storage (7.2)��ڻ��.  ����SecID �� ��SAT�а���. 

  short-stream container stream �õ��������������� ��SecID ����������  ��һ��, ���stream ������Ϊshort-sectors, �������������ļ��������� ��������û��header �ṹ�� ��Ȼ, ��һ��������(short-secotr)(SecID 0) ͨ����short-stream container stream ��ƫ����Ϊ0.   short-sector �Ĵ�С��header �ж��塣  �������Ϣ����ͨ��SecID�����short-stream �� short-stream container stream �е�ƫ����

  short_sec_pos(SecID) = SecID * short_sec_size = SecID * 2 ^ sssz

  ����:   sssz = 6 , SecID = 5

  short_sec_pos(SecID) = SecID * 2 ^ sssz = 5 * 2 ^ 6 = 5 * 64 = 320

. SSAT (Short-Sector Allocation Table )

  SSAT ��һ��SecIDs �����顣 ��������short-stream ��SecID��,  ������SAT ������׼stream��SecID ��. 

  SSAT�ĵ�һ��SecID ��header�ж���.  ʣ���SecID ����SAT��. SSAT ��ͨ����ȡ ������ ������Ϣ��������.

  SSAT������ (sec_size ���������ֽڴ�С 4.1 )

  ------------------------------------
  Offset    Size      Contents
  ------------------------------------
  0        sec_size   Array of sec_size/4 SecIDs of the SSAT
  ------------------------------------

. 7. Ŀ¼ Directory 

. 7.1 Ŀ¼�ṹ

  directory ���ڲ�������. ��Ŀ¼���(directory entries)���.  ÿһ��Ŀ¼���ָ��һ��storage ��һ��stream.  Ŀ¼��ڰ�������stream��˳������.  ����Ϊ0 ��Ŀ¼��� ��Ϊ Ŀ¼���ID ( DirID)

    -----------------------------
    Directory Entry 0

    Directory Entry 1
 
    Directory Entry 2

    Directory Entry 3

    ....

    -------------------------------

    Ŀ¼�����storage �� stream�� �����ļ��д���ʱ��һ�¡� ���storage �� stream �Ƴ���, ��Ӧ�� Ŀ¼���Ҳ�ᱻ�ÿա� DirID 0 �ǱȽ������, ��Ŀ¼�Ŀ�ʼ, ������root stroage �� ��Ϊ root storage entry.

    Ŀ¼��� �� ����� ����֯ÿһ��storage��ֱ�ӳ�Ա(storage��stream).  red-black tree.  �������� storage �� stream  ֮��Ĺ�ϵ.   

    �򵥵�˵, ������еĽڵ� ����ﵽһЩ������:

        1. root �ڵ��� black  ��

        2. ��ڵ�ĸ��ڵ� �� black

        3. ��root �� Ҷ��֮���·�� ������ͬ�����ĺڽڵ�

        4. ��ߵĺ��ӽڵ� ���� �ұߵĺ��ӽڵ�.

    ������Ҫע�����, �������е�ʵ���������Щ����. �ȫ�ķ�ʽ�Ƕ�ȡDirectory Entry�� ���Խڵ���ɫ, �ع������.

   ÿ��Ŀ¼��ڰ���3��DirIDs: ����DirID �������Ǻ�������������,  �Һ��� �Ǻ�������Һ��ӡ� ������DirID �ǰ��������� stream �� �� storage �ĺ�����ĸ��ڵ��DirID. 

  ע�⣬ ͨ��entry���Ƶĳ���Ҳ�����ж����Һ���, �̵����� ��������.

. 7.2 Ŀ¼���

  
. 7.2.1  Ŀ¼��ڽṹ

   ÿһ��Ŀ¼��ڶ��Ǿ�ȷ��128�ֽ�.  ���ָ�ʽ��Ϊ��ͨ��DirIDs ������ ���� Ŀ¼���е�ƫ����.

   dir_entry_pos(DirID) = DirID * 128

   Ŀ¼��ڽṹ�� ��������: (-1 = 0xFFFFFFFF)

   ------------------------------------
   Offset     Size     Contents
   ------------------------------------
     0         64       �ַ���. �������. ͨ����16λUnicode �ַ�����β0����(ʵ���������ֻ����31���ַ�)

     64        2        ���Ƶ��ַ������С. ����β0.  ����: 5���ַ�������: (5+1) * 2 = 12 �ֽ�

     66        1        �������.  00h = ��                 01h = User Stroage      02h = User stream 
                                   03h = LockBytes(unknown) 04h=Property(unknown)   05h = Root storage

     67        1        ��ڵĽڵ���ɫ.   00h = Red       01h = Black

     68        4        red-black tree ����ӽڵ��DirID(��������User storage �� stream), -1 ��ʾû�������ӽڵ�.

     72        4        red-black tree �ұ��ӽڵ��DirID(��������User storage �� stream), -1 ��ʾû�������ӽڵ�.

     76        4        ����storage ��Ա�� red-black tree  �е�root �ڵ��DirID. -1 �������.

     80        16       UID, �����һ��storage �Ļ����У� ����ȫ��Ϊ0

     96        4        User flags (����������ݶ��Կ�������,  ����ȫ��Ϊ0)

    100        8        ���������ڵ�ʱ���. ͨ������д�Ϸ�ʱ��, ���Ƕ�д0.

    108        8        �޸������ڵ�ʱ���.  ͨ������д�Ϸ�ʱ��, ���Ƕ�д0

    116        4        ������������ĵ�һ��SecID�� ���������ָ��һ��stream������short-stream container stream 
                        �ĵ�һ������SecID; �����root storage ���, 0. �������

    120        4        ���е�stream ���ֽڴ�С.���������ָ��һ��stream,����short-stream container stream�������ֽ���
                        �����root storage ���, 0 

    124        4        Not Used
   ----------------------------------------------

   *** ����Ҫ, ����Excel ���Ǵ�Directory ��Entry ����ʼ����ġ� 

. 8. ����                         


. 8.2. �����������  MSAT

   header ��������MSAT, ���Ҳ ûɶ������ MSAT ���� SecID ����ɡ�

. 8.3 SAT  ���������

  Ϊ�˹���SAT, MSAT �е����������������ܶ�ȡ��.���������ֻ������0.��ʼ���ļ�ƫ����0000 0200H = 512 , ����(�ԣ��μ�ԭ��)  

. 8.4 SSAT  �����������

. 8.5 Ŀ¼

  ------------------------------------�����ķָ��� -------------------


. 

. Excel �ļ��ṹ

. 2.3.1 ���ļ�

  �����ļ����ͺ�BIFF �汾���Դ洢��һ���򵥵����ļ���, �󲿷ֶ������ִ洢��ʽ. ��һ������, BIFF5-BIFF8 workbook �ĵ�, ���洢�ڸ����ĵ�.  �����Щ�ĵ���Ϊ���ļ��洢, ��ô�����ļ�����"Book"��(BIFF5) �� "Workbook"��(BIFF8) ���.

. 2.3.2 �����ĵ��ļ�(BIFF5-BIFF8)  Compound Document File

  һ���м���sheets(BIFF5-BIFF8)��workbook �ĵ��� ͨ���洢Ϊ�����ĵ��ļ���ʽ(Ҳ����"OLE2 storage file format" ���� "Microsoft Office compatible storage file format"). ����������streams ��Ӧ��ͬ���͵�����.  compound document �μ�����ĵ�

  �����ǿ��ܵ���stream

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

  Ҳ�������ļ�ϵͳ����Ŀ¼һ������substorages, ���� PivotTable stream.  ��Щ storage ���� ���� substreams

  ------------------
  Storage name                 contents
  --------------------
  LNKxxxxxxxx                  Storage for a linked OLE object (6)

  MDBxxxxxxxx                  Storage for an embedded OLE object(6)

  _SX_DB_CUR                   Pivot cache storage. ���streams ���������� PivotTables(8) 

  _VBA_PROJECT_CUR             Visual BASIC project storage
  -------------------------


. 2.3.3 Worksheet/Workbook/Workspace Stream

  Worksheet Stream ��4.1.1 ����ϸ����.

  Workbook Stream ��4.1.2 ����ϸ����

  Workspace Stream ��10 ����ϸ����

. 2.3.4 Substreams

  BIFF5-BIFF8 Workbook stream ��Ϊ������������ workbook global �� ������sheets(��)(2.1.3). ÿһ���ֽ���һ��substream. ��stream �ж����˿�ʼ�ͽ���λ��.

  ����: Workbook Globals Substream

      ���substream ����workbook �� global information. ���� Workbook Globals Substreams. �� Workbook Stream ��һ����.

  ����: Sheet Substream

    
. 2.4 BIFF ��¼�ṹ  ---- BIFF Record      P16

   �󲿷� Excel ��stream�� substream ���ǲ��Ϊrecords ��������.  ÿ����¼���в�ͬ������.  ������ͷ�����ƶ���¼���ͺʹ�С, ����ľ��Ǽ�¼������

   ��ͨ��BIFF ��¼�ṹΪ

   ---------------------------
   Offset       Size         Contents
   ------------------------------------
   0            2            Identifier                                  }
                                                                         }   ��¼ͷ
   2            2            Size of the following data(sz)              }
  ---------------------------------------------------------

   4            sz           Record data
  --------------------------------------------------

  ��¼���ݵ���󳤶������� BIFF�İ汾.  .����������continue....

  ͨ����¼���ݵ�offset ������ڱ���¼�Ŀ�ʼ, ���������м�¼�Ŀ�ʼ. 

   


. 4. Worksheet/Workbook Stream     P79

  Excel �ĵ��ĸ������ݲ��Ϊ������¼.  Ϊ�˱���Worksheet/Workbook Stream һ�£� ��¼��λ�ú�˳��ǳ���Ҫ. ���¾���ϸ����stream �еļ�¼.  ��¼���ڲ��ṹ�μ���5��.

.4.1.1. Worksheet Stream (BIFF2-BIFF4)

 Worksheet Stream (BIFF2-BIFF4)�еļ�¼:

     BOF                         Type = sheet , chart, macro sheet (5.8   p135)

     EOF                         5.37   ( ?? û����һ��) �����鿴ID Ӧ���� 000AH  ��Ӧ�ĵ�Ӧ���� 0A 00

. 4.1.2 Workbook Stream (BIFF5-BIFF8)

  ͨ���ṹΪ:

   .   Workbook Globals Substreams

   ..  Sheet Substreams

  Workbook Stream �еļ�¼Ϊ: BIFF5-BIFF8

   .  BOF  Type = workbook globals (5.8  )

   .  EOF  5.37

   ..      . BOF     Type = sheet, chart, macro sheet, Basic module, ... ( 5.8 )

           .. EOF    5.37

. 4.2  Streams �� Substreams  �еļ�¼˳��

. 4.2.5 Record Order in a BIFF8 Workbook Stream  **********************  ����Ƿǳ��ؼ���һ�ڣ� ˵���˵�һ��stream �Ľṹ

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

             PROT4REV               �Ƿ����뱣��

             PROT4REVPASS           ������Ϣ

   WINDOW1                            -> 5.109            003Dh    P215

       BACKUP                         -> 5.5              0040h    P133

       HIDEOBJ                        -> 5.56             008Dh    P181   

       DATEMODE                       -> 5.28             0022h    P154  

       PRECISION                      -> 5.79             000Eh    P198

       REFRESHALL

       BOOKBOOL                       -> 5.9              00DAh     P137
 
  .. FONT                             -> 5.45             0031h     P171

       FORMAT                         -> 5.49             041Eh     P174

  .. XF                               -> 5.115            00E0h     P219     ��չ��ʽ

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

    �ļ���д����/��д������������Ϣ

    �ṹΪ:

       WRITEPROT         ������ FILESHARING   5.113      P218     0086h

       FILEPASS          ��д����, ��֤��Ϣ  5.43       P168     002Fh(ID)

       WRITEACCESS       �û���   5.112            P218   005Ch

               offset      size      contents
                0           var       user name, byte string, 16-bit string length, 109 characters   2.5.3

       FILESHARING       File sharing options   5.44          005Bh      P 170

   File Protection Block ��¼���ļ��ĵ�һ����¼.  4.2    P81

   ### SHEET ��¼�ܹؼ�  0085h   5.95 P 206

   �ü�¼��Workbook Globals Substream �� ���� workbook�����һ����(sheet). һ��SHEET ��¼��Ӧһ��sheet. ������sheet ������, �Լ�һ��stream ��BOF ��¼�� ƫ����. Ҳ���� Sheet SubStream �� Workbook Stream ��ƫ����. 

    -----------------------------------
    Offset        Size     Contents
    -------------------------------------
     0            4        ������¼��Ӧ�ı���BOF��¼�ľ���stream λ�á� ����ֶμ������ļ�������Ҳ�����м��ܡ�

     4            1        ��״̬    0 �ɼ�  1  ����  2 Very hidden(�������ã� �ű���)

     5            1        ������    00h  Worksheet  02h chart  06h VB module

     6            var      ������    BIFF8: Unicode String, 8λ�ַ�������  2.5.3 (P17)

     
   ====
   Unicode String  (2.5.3 P17)

   ----------------
   Offset      Size         contents
   ---------------
   0           1 or 2       �ַ�������(���ַ�����)    (��2�ֽ�������ɡ�������)

   1 or 2      1            ��ѡflags

                            -----------------------
                            Bit     Mask      contents
                            ------------------------
                             0      01h       �ַ�ѹ��(ccompr)  0   8λ�ַ�ѹ���� 1 16Ϊ�ַ�ѹ��

                             2      04h       ���޵绰����(phonetic) 0 ���������޵绰���ã� 1 �������޵绰����

                             3      08h       Rich-Text ����(richtext) 0 ������Rich-text����,  1 ����
                            --------------------------
   [2 or 3]      2         ��ѡ(richtext =1 ����) Richtext�ĸ��� rt��

   [var]           4         ��ѡ��phonetic=1   ���޵绰���ÿ� ��С  sz.

   var      ln or 2 * ln    �ַ�����. 8λ��16λ, ������ccompr    

   [var.]       4*rt        2.5.1   richtext ==1 �� rt ��ʽ�б�

   [var.]       sz          if phonetic == 1.  ���޵绰���ÿ�

   ######################

   --------------SST -----------  5.100   P210
    Offset     Size     Contents
   -----------------------------
     0         4         workbook �е��ַ������� Total 

     4         4         ������ַ�������(nm)

     8         var       nm Unicode�ַ����б�, 16λ�ַ�������   2.5.3
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

  first last   ���   XF     flags   û��
  0000  0000   6008   3E00   0600    0200

  A600  A600   A012   3E00   0600    0200       00A6  = 166
 
  A700  0001   0009   3E00   0000    0200       00A7  = 167     Last < first ˵��col ������

  �������ݴ������, ������¼���Ժ��ԡ�



. DIMENSION      5.35  P160
 
  first Row       last  Row      first col    last col    û��
  00000000        F0290000       0000         A700        0000

  29F0 = 10736  Ҳ���� Excel ʵ������

  00A7 = 167  Ҳ����ʵ������

  ��0�к͵�0�ж���ϵͳ�����ˣ� ������ʾ�±�  A1, B2֮���

  �������ݵ�ʱ��, ���Ҳ����Ҫ. ������ǰ�ж��ж����У� �����С� 


. ROW  ��¼    5.88  P202   

  row     first col   last col   �߶�     û��     û��       flag, ��ʽ
  0000    0000        A700       0E01     0000     0000       00010F00

  5F28    0000        A700       0E01     0000     0000       00010F00

  �������ݴ������, ������¼���Ժ��ԡ�

. DBCELL    5.29   P155   00D7h

  Row ���г���һ��.  ������¼�����Row ��Ե�һ��Row �����λ�á� ��Ҫ��Row ��¼���ܲ���ȫ����һ��

  ����Ǵ������ݵĻ�, ������¼Ҳ���Ժ��ԡ�   


. LABELSST    5.65  P188                    ****** ��� SST  �ǻ�ȡ���ݵĹؼ�������

  ��Ԫ����ַ���.
  -----------------------------------
  Offset    Size       Contents
  ------------------------------------
  0         2          ������

  2         2          ������

  4         2          XF ��¼����  XF  5.115->   P219

  6         4          SST ��¼����  5.100     ->P210
 --------------------------------------------


  ����:
      0000  0000  3F00    A35C0200    

      3F00 -> 0x3F -> 63 

      A35C0200 -> 0x25CA3 = 154787    -> ��Ӧ SST �����ݾ���"������"  SST[154787] = "������"

      EF29 A600 4000  565D0200

      EF29 -> 29EF = 29F0-1 = 10735  (ӦΪ��Ԫ���±��Ǵ�0��ʼ, ʵ�ʶ�Ӧ����10736��)

      A600->00A6 = 166    ��Ӧ 166��

      565D0200 -> 0x025D56 = 154966  -> SST[154966] = "44.00"  ����  �������, Ӧ���ǿո�ѽ����

. <05H>SummaryInformation ���ĸ�ʽ

 0-27(00h-1Bh)       28�ֽ�       <05H>SummaryInformation ����ͷ��, ��������

     0-1             2             16λ����, �ֽ�����ʽ

     2-3             2             16λ����, ������֤��.  һ��û��, ͨ��Ϊ0

     4-5             2             ����ϵͳ�汾��, ǰһ���ֽڱ�ʾ���汾, ��һ���ֽڱ�ʾ�ΰ汾. ����Windows xp, Ϊ"05 01"

     6-7             2             16Ϊ����, ����ϵͳ,  2: win32, 1: mac,  0: win16

     8-23(08h-17h)   16            ���������(the stream's class id)�� ��ʽΪ: dword + 2 words + 2bytes + 6 bytes 
                                   dword ��32λ����, word ��16λ����, byte ��8λ����, ֵΪ:
                                   "00000000-0000-0000-0000-000000000000"
  
    24-27(18h-1bh)   4             32λ����, ��ʾ���� �ڵĸ���(section)��ͨ��<05h>SummaryInformation��ֻ��1��, ��ֵ����1

  ������ͷ������ ������, �� 20���ֽ�, 2���ֶ�

    28-43(1Ch-2Bh)   16            �ڵ������(section's class id), ����<05h>SummaryInformation ���� ��ֵΪ
                                   "f29f85e0-4ff9-1068-ab91-08002b27b3d9"   

    44-47(2Ch-2Fh)   4             32λ����, ��ʾ������ ����� ����ʼλ�õ�ƫ����. ֵͨ��Ϊ48(30h)   

    ��ͷ��, ��ʾ����, �ڵ�ƫ����Ϊ48(30h)�� ��ͷ����8���ֽ�, ��2���ֶ�, �ڽ���:

    0-3              4             (ʾ����, ��Ӧ��ƫ����Ϊ48-51�� 30h-33h����ͬ)��32λ����, ��ʾ�ڳߴ�.

    4-7              4              32λ����, �������Ը���

   �����Ž�ͷ��, ������(�����Ը���, ʾ����Ϊ8��)����������, ��������������32λ��������, ǰ��Ϊ���Ա���(ID), ����Ϊ������������ڽ���ʼλ�õ�ƫ������

   ����<05h>SummaryInformation ��, ���Ա���(ID)���京������:

       ----------------------------
       ���Ա���ID          ����               ��������(�����н���, ��ͬ�����ͺ�������ݸ�ʽ��ͬ)
       -----------------------------------------------
       1(01h)              ����ҳ             2(02h)

       2(02h)              ����               30(1Eh)

       3(03h)              ����               30(1Eh)

       4(04h)              ����               30(1Eh)

       5(05h)              �ؼ���             30(1Eh)

       6(06h)              ��ע               30(1Eh)

       7(07h)              ģ��               30(1Eh)

       8(08h)              ��󱣴�           30(1Eh)

       9(09h)              ������             30(1Eh)

       10(0Ah)             �ܱ༭ʱ��         64(40h)

       11(0Bh)             ����ӡʱ��       64(40h)

       12(0Ch)             ����ʱ��           64(40h)

       13(0Dh)             ��󱣴�ʱ��       64(40h)

       14(0Eh)             ҳ��               3(03h)

       15(0Fh)             ����               3(03h)

       16(10h)             �ַ���             3(03h)

       17(11h)             ����ͼ             71(47h)

       18(12h)             �����ĵ��ĳ������� 30(1Eh)

       19(13h)             ��ȫ               3(03h)

   �������ݵĳ��Ȳ��ǹ̶���, �������������й�, �������ݵĵ�һ��32λ������ʾ��������, �������ľ������Ե�ֵ, �������ͼ��京������:

      -----------------------------
       ��������         ����
      -----------------------------
       2(02)           16λ����������

       3(03)           32λ����������

       19(13h)         32λ�޷�������

       30(1Eh)         �ַ��� ( ��ʽ: 32λ ������ʾ���� + 0��β���ַ���)

       64(40h)         ʱ���

       71(47h)         �������ʽ
      ------------------------------------

  ��ṹ�롰<05H>SummaryInformation�������ƣ�����ͬ���ǽڵ�����루section's class id����ֵΪ��d5cdd502-2e9c-101b-9397-08002b2cf9ae����

<05H>DocumentSummaryInformation��������Ҫ�������ļ������йص����ԣ���ˣ����ݲ�ͬ���͵��ļ��������Ա��뼰��������������һЩ��չ������Ͳ���һһ�����ˡ�


. 5.8 BOF --- Beginning of File

   -------------------------------------
   BIFF2    BIFF3     BIFF4       BIFF5      BIFF8
   -----------------------------------------------
   0009h    0209h     0409h       0809h       0809h
   -------------------------------------------------
. 5.81  Excel д�� BOF ��¼

  BIFF5    0809h
  ---------------------
  offset      size    contents
  --------------------------
   0          2        BIFF �汾(BIFF5 ͨ����0500h). �����workbook

   2          2        �������ݵ�����.  0005h = Workbook globals  
                                        0006h = Visual Basic module
                                        0010h = Sheet or dialogue (see SHEETPR, 5.97)
                                        0020h = Chart
                                        0040h = Macro sheet
                                        0100h = Workspace(BIFF5W only)

   4          2        Build identifier . ����Ϊ0

   6          2        Build year
  --------------------------------------------

  BIFF8    0809h
  ---------------------
  offset      size    contents
  --------------------------
   0          2        BIFF �汾(BIFF8 ͨ����0600h). �����workbook

   2          2        �������ݵ�����.  0005h = Workbook globals  
                                        0006h = Visual Basic module
                                        0010h = Sheet or dialogue (see SHEETPR, 5.97)
                                        0020h = Chart
                                        0040h = Macro sheet
                                        0100h = Workspace(BIFF5W only)

   4          2        Build identifier . ����Ϊ0

   6          2        Build year. ����Ϊ0

   8          4        �ļ���ʷflags

  12          4        �ܶ�ȡ���ļ������Excel �汾
  --------------------------------------------
