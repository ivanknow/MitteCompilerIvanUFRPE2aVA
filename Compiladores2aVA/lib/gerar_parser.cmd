java -jar java-cup-11a.jar -expect 1 -parser Parser <..\src\syntax\Parser.cup
move /Y *.java ..\src\syntax\
@if [%1]==[] pause