grammar Mx;
program:subprogram*;
subprogram:functiondef|classdef|variabledef;
functiondef:(vartype)? ID '(' parameter? ')' block;
classdef:'class' ID '{'(variabledef|functiondef)*'}' ';';
variabledef:vartype ('['']')* (ID ('=' expression)?) (',' ID ('=' expression)?)*;
block:'{'stat*'}';
stat:block
    |variabledef ';'
    //|ID('['(INT|ID)']')* '=' (expression|'null') ';'
    |expression ';'
    |'if' '('expression')' stat ('else' stat)?
    |'return' (expression)?';'
    //|functionuse
    |'for' '('(expression)?';'(expression)?';'(expression)? ')' stat
    |'while' '(' expression ')' stat
    |'break'
    |'continue'
    |';';
//allocformat: vartype ('[' expression ']')+ ('[' ']')+ ('[' expression ']')+        #allocErrorType
//                |   vartype ('[' expression ']')+ ('[' ']')*                       #allocArrayType
//                |   vartype ('(' ')')?                                             #allocBaseType
//                ;
expression://((ID('['(INT|ID)']')*('.'ID('('(parameterforcall)?')'))?)|INT) (OPEATOR expression)?|
           'new' vartype ('[' (expression)? ']')*
          |ID
          |(BOOL|INT|'null'|STRING)
          |'('expression')'
          |expression '=' expression
          |expression ('++'|'--')
          |('++'|'--'|'-'|'!'|'~'|'+') expression
          |expression ('+'|'-'|'*'|'/'|'%') expression
          |expression ('>>'|'<<') expression
          |expression ('&&'|'||') expression
          |expression ('&'|'|'|'^') expression
          |expression ('>'|'<'|'>='|'<='|'=='|'!=') expression
          |expression '['expression']'
          |expression '.' ID                                                       //#objPortion
          |expression '(' (parameterforcall)? ')'
          |'['('&')?']' ('('parameter?')')? '->' block '('parameterforcall?')';
//functionuse:ID'('(functionuse|parameterforcall)?')';
//functionuse:'print('expression')'|'println('expression')'|'printInt('expression')'|'printlnInt('expression')'|'getString('expression')'|'getInt('expression')'|'toString('expression')';
//KEYWORD:'new'|'class'|'null'|'this'|'if'|'else'|'for'|'while'|'break'|'continue'|'return';
parameterforcall:expression(','expression)*;
parameter:vartype ID (',' vartype ID)*;
vartype:'void'|'bool'|'int'|'string'|ID;
OPEATOR:'+'|'-'|'*'|'/'|'='|'<'|'>'|'<='|'>='|'=='|'!='|'<<'|'>>'|'++'|'--'|'!'|'~'|'%'|'&'|'|'|'^'|'&&'|'||';
BOOL:'true'|'false';
ID:[a-zA-Z][a-zA-Z_0-9]*;
INT:[1-9][0-9]+|[0-9];
STRING:'"' (~('"')|'\\"'|'\\n'|'\\')* '"';
WS:[ \t\r\n]+ ->skip;
COMMENT:('//' ~[\r\n]*|'/*' .* '*/') ->skip;

//problem:ID?关键字 funcuse?new?