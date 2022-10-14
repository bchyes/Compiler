grammar Mx;
program:subprogram*;
subprogram:functiondef|classdef|variabledef ';';
functiondef:(functype)? ID '(' parameter? ')' block;
classdef:'class' ID '{'(variabledef ';'|functiondef)*'}' ';';
variabledef:vartype (baseVarDef) (',' baseVarDef)* ;
block:'{'stmt*'}';
stmt:block                                                                                                                   #innerBlock
    |variabledef ';'                                                                                                         #vardefStmt
    //|ID('['(INT|ID)']')* '=' (expression|'null') ';'
    |expression ';'                                                                                                          #exprStmt
    |IF '('condition=expression')' thenStmt=stmt (ELSE elseStmt=stmt)?                                                       #ifStmt
    //|functionuse
    |FOR '('(initDef=variabledef|initExpr=expression)?';'(condition=expression)?';'(incrExpr=expression)? ')' loopBody=stmt  #forStmt
    |WHILE '(' condition=expression ')' loopBody=stmt                                                                        #whileStmt
    |jumpStmt                                                                                                                #jumpStatement
    |';'                                                                                                                     #blankStmt
    ;
jumpStmt:BREAK ';'
        |CONTINUE ';'
        |RETURN (expression)?';'
        ;
//allocformat: vartype ('[' expression ']')+ ('[' ']')+ ('[' expression ']')+        #allocErrorType
//                |   vartype ('[' expression ']')+ ('[' ']')*                       #allocArrayType
//                |   vartype ('(' ')')?                                             #allocBaseType
//                ;
expression://((ID('['(INT|ID)']')*('.'ID('('(parameterforcall)?')'))?)|INT) (OPEATOR expression)?|
          ID                                                                         #identifier
          |(True|False|INT_C|NULL|STRING_C)                                          #constant
          |expression '.' ('('ID')' | ID)                                            #objPortion
          |NEW allocFormat                                                           #allocExpr
          |expression '(' (parameterforcall)? ')'                                    #funcCall
          |'('expression')'                                                          #compoundExpr
          |array=expression '['index=expression']'                                   #arrayAccess
          |operand=expression op=('++'|'--')                                         #aftermonocularOp
          |<assoc=right> op=('++'|'--'|'!'|'~') operand=expression                   #monocularOp
          |operand1=expression op=('*'|'/'|'%') operand2=expression                  #binaryExpr
          |operand1=expression op=('+'|'-') operand2=expression                      #binaryExpr
          |<assoc=right> op=('-'|'+') operand=expression                             #monocularOp
          |operand1=expression op=('>>'|'<<') operand2=expression                    #binaryExpr
          |operand1=expression op=('>'|'<'|'>='|'<='|'=='|'!=') operand2=expression  #binaryExpr
          |operand1=expression op='&' operand2=expression                            #binaryExpr
          |operand1=expression op='^' operand2=expression                            #binaryExpr
          |operand1=expression op='|' operand2=expression                            #binaryExpr
          |operand1=expression op='&&' operand2=expression                           #binaryExpr
          |operand1=expression op='||' operand2=expression                           #binaryExpr
          |<assoc=right>operand1=expression op='=' operand2=expression               #binaryExpr
          |'this'                                                                    #objPointer
          |'['('&')?']' lambdaparameter? '->' block '('parameterforcall?')'          #lambdaExpr
          ;
//functionuse:ID'('(functionuse|parameterforcall)?')';
//functionuse:'print('expression')'|'println('expression')'|'printInt('expression')'|'printlnInt('expression')'|'getString('expression')'|'getInt('expression')'|'toString('expression')';
//KEYWORD:'new'|'class'|'null'|'this'|'if'|'else'|'for'|'while'|'break'|'continue'|'return';
allocFormat:(BOOL|INT|STRING|ID) ('[' expression ']')*  ('[' ']')+ ('[' expression ']')+        #allocErrorFormat
           |base=(BOOL|INT|STRING|ID) ('[' expression ']')+  ('[' ']')*                         #allocArrayFormat
           |base=(BOOL|INT|STRING|ID) ('(' ')')?                                                #allocBaseFormat
           ;
parameterforcall:expression(','expression)*;
parameter:vartype ID (',' vartype ID)*;
vartype:(BOOL|INT|STRING|ID) #baseType
       |vartype '['']'       #arrayType
       ;
baseVarDef:ID ('=' expression)?;
functype:vartype|VOID;
lambdaparameter:('('parameter?')');
BOOL:'bool';
VOID:'void';
INT:'int';
STRING:'string';
IF:'if';
ELSE:'else';
FOR:'for';
WHILE:'while';
NEW:'new';
NULL:'null';
BREAK:'break';
CONTINUE:'continue';
RETURN:'return';
OPEATOR:'+'|'-'|'*'|'/'|'='|'<'|'>'|'<='|'>='|'=='|'!='|'<<'|'>>'|'++'|'--'|'!'|'~'|'%'|'&'|'|'|'^'|'&&'|'||';
True:'true';
False:'false';
ID:[a-zA-Z][a-zA-Z_0-9]*;
INT_C:[1-9][0-9]+|[0-9];
STRING_C:'"' (~('"')|'\\"'|'\\n'|'\\')* '"';
WS:[ \t\r\n]+ ->skip;
COMMENT:('//' ~[\r\n]*|'/*' .* '*/') ->skip;

//problem:ID?关键字 funcuse?new?