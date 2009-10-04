@echo off

g++ -fPIC -c glue.cpp -ID:\Progs\Java\jdk1.6.0_10\include -ID:\Progs\Java\jdk1.6.0_10\include\win32
g++ -shared -Wl,--kill-at -o glue.dll glue.o

gcc -c myjvm.c -ID:\Progs\Java\jdk1.6.0_10\include -ID:\Progs\Java\jdk1.6.0_10\include\win32
gcc -o myjvm myjvm.o -LD:\Progs\Java\jdk1.6.0_10\lib -ljvm

@pause
