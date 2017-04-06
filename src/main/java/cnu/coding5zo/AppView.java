package cnu.coding5zo;
public class AppView {
	
	public void outputResult(double aValue) {
		System.out.println("\n[최종값] " + aValue + "\n");
	}
	
	public void outputMessage(MessageID aMessageID) {
		if (aMessageID == MessageID.Notice_StartProgram){
			System.out.println(" :: 프로그램을 시작합니다. ::");
		}
		
		else if (aMessageID == MessageID.Error_Input)
			System.out.println("ERROR: 잘못된 입력입니다.");
		
		else if (aMessageID == MessageID.Notice_EndProgram)
			System.out.println(" :: 프로그램을 종료합니다. ::");
	}
	
}
