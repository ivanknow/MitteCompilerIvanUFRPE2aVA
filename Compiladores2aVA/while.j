.class public while
.super java/lang/Object 

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

.method public static main([Ljava/lang/String;)V 

.limit locals 5

.limit stack 5
bipush 0

istore_0

loop0:
iload_0
bipush 10
if_icmpge else1
bipush 1
goto fim1
else1:
bipush 0
fim1:

bipush 1
if_icmpne fim0
getstatic java/lang/System/out Ljava/io/PrintStream;
iload_0

invokevirtual java/io/PrintStream/println(I)V
iload_0
bipush 1
iadd

istore_0

goto loop0
fim0:

return
.end method


