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
bipush 0
istore_1
iload_1

bipush 4

istore_1

getstatic java/lang/System/out Ljava/io/PrintStream;
bipush 2
iload_1
iadd
invokevirtual java/io/PrintStream/println(I)V
return
	.end method


