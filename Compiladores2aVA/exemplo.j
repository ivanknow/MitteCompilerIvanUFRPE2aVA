.class public exemplo
.super java/lang/Object 

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

.method public static main([Ljava/lang/String;)V 

.limit locals 5

.limit stack 5
ldc 4.0

fstore_1

getstatic java/lang/System/out Ljava/io/PrintStream;
ldc 2.0
fload_1
fadd

invokevirtual java/io/PrintStream/println(F)V
getstatic java/lang/System/out Ljava/io/PrintStream;
fload_1
ldc 3.3
fcmpgt

invokevirtual java/io/PrintStream/println(Z)V

return
	.end method


