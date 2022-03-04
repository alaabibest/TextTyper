package ir.alirezaabdolmaleki.textTyper.Typer;

public class Texts
{
	String text;

	public Texts(String text)
	{
		this.text = text;
	}

	public String[] getText()
	{
		
		String[] text2 = text.split("");
		
		return text2;
	}
}
