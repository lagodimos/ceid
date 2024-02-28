#include <stdio.h>
#include <stdlib.h>

#define OPERAND 1
#define STACK_SIZE 2

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int getOp(char op[]);
void putInStack(char s[]); // char *s
int getFromStack(void);
void add(void);
void mul(void);
void presentResult(void);
void push(int n);
int pop(void);

//char operand[20];
//int inputType;

//int stack[50];
//int sp=0;

int main(int argc, char *argv[]) {
	char operand[20];
	int inputType;

	printf("RPN Calculator\n");
//	push(10);
//	push(3);
//	printf("pop=%d\n",pop());
//	printf("pop=%d\n",pop());
//	inputType=getOp();
	while((inputType=getOp(operand))!=EOF){
//		printf("inputType= %c(as char)\t %d(as decimal)\n",inputType,inputType);
//		printf("operand=%s\n",operand);
		switch(inputType){
			case OPERAND:
				putInStack(operand);
				break;
			case '+':
				add();
				break;
			case '*':
				mul();
				break;
			case '=':
				presentResult();
				break;
			default:
				printf("operation not suported\n");

		}
//		inputType=getOp();
	}

	return 0;
}

int getOp(char op[]){
	char ch;
//	printf("Eneter RPN expression\n");
	ch=getchar();
	while(ch==' '|| ch=='\n')
		ch=getchar();
	if(isdigit(ch)){
		op[0]=ch;
		op[1]='\0';
		return OPERAND;
	}
	else
		return ch;
}


void putInStack(char s[]){
//	printf("putInStack\n");
	push(atoi(s));
}


int getFromStack(void){

}

void add(void){
//	printf("add\n");
	int op1,op2;
	op1=pop();
	op2=pop();
	push(op1+op2);
}
void mul(void){
	printf("mul\n");
}
void presentResult(void){
//	printf("presentResult\n");
	printf("result=%d\n",pop());
}

int stack[STACK_SIZE];
int sp=0;

void push(int n){
	if(sp>=STACK_SIZE)
		printf("Stack full\n");
	else
		stack[sp++]=n;
//	sp++;
}

int pop(void){
//	sp--;
if(sp==0)
	printf("stack empty\n");
else
	return stack[--sp];
}


int stack2[STACK_SIZE];
int sp2=0;

//void push2(int n){
//	if(sp2>=STACK_SIZE)
//		printf("Stack full\n");
//	else
//		stack2[sp++]=n;
////	sp++;
//}
//
//int pop2(void){
////	sp--;
//if(sp2==0)
//	printf("stack empty\n");
//else
//	return stack2[--sp];
//}

//void push(int *stack,int sp,int n){
//	if(sp>=STACK_SIZE)
//		printf("Stack full\n");
//	else
//		stack[sp++]=n;
////	sp++;
//}
//
//int pop(int *stack,int sp){
////	sp--;
//if(sp==0)
//	printf("stack empty\n");
//else
//	return stack[--sp];
//}
//
//struct stack{
//	int ops[STACK_SIZE];
//	int sp=0;
//}st1,st2;
//
//push(st1,10);
//push(st2,12);
