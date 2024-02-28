#include <stdio.h>
#include <stdlib.h>

#define OPERAND 1
#define STACK_SIZE 2

typedef struct stack {
	int sp;
	int stack[STACK_SIZE];
} Stack;

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
int getOp(char op[]);
void putInStack(char s[]); // char *s
int getFromStack();
void add();
void sub();
void mul();
void divi();
void presentResult();
void push(int n);
int pop();

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
	while((inputType=getOp(operand)) != EOF) {
//		printf("inputType= %c(as char)\t %d(as decimal)\n",inputType,inputType);
//		printf("operand=%s\n",operand);
		switch(inputType) {
			case OPERAND:
				putInStack(operand);
				break;
			case '+':
				add();
				break;
			case '-':
				sub();
				break;
			case '*':
				mul();
				break;
			case '/':
				divi();
				break;
			case '=':
				presentResult();
				break;
			default:
				printf("operation not suported\n");

		}
	}

	return 0;
}

int getOp(char op[]) {
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


void putInStack(char s[]) {
//	printf("putInStack\n");
	push(atoi(s));
}


int getFromStack() {

}

void add() {
	push(pop() + pop());
}

void sub() {
	int n = pop();
	push(pop() - n);
}

void mul() {
	push(pop() * pop());
}

void divi() {
	int divisor = pop();

	if (divisor != 0)
		push(pop() / divisor);
	else {
		push(divisor);
		printf("Division by 0! Operation ignored.");
	}
}

void presentResult() {
	printf("result=%d\n",pop());
}

Stack st1 = {0};

void push(int n) {

	if(st1.sp>=STACK_SIZE)
		printf("Stack full\n");
	else
		st1.stack[st1.sp++]=n;
}

int pop() {
	if(st1.sp==0)
		printf("stack empty\n");
	else
		return st1.stack[--st1.sp];
}
