public class AppView {
	
	public void outputResult(double aValue) {
		System.out.println("\n[������] " + aValue + "\n");
	}
	
	public void outputMessage(MessageID aMessageID) {
		if (aMessageID == MessageID.Notice_StartProgram){
			System.out.println(" :: ���α׷��� �����մϴ�. ::");
			System.out.println("�����ҷ��� ! �� �Է��ϼ���");
		}
		
		else if (aMessageID == MessageID.Error_Input)
			System.out.println("ERROR: �߸��� �Է��Դϴ�.");
		
		else if (aMessageID == MessageID.Notice_EndProgram)
			System.out.println(" :: ���α׷��� �����մϴ�. ::");
	}
	
}
