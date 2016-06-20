package Matrica;

public class ShkronjNumer {
	

	public static int shkronjeNeNumer(String a)
	{
		String lower = a.toLowerCase();
		int nr = 0;
		switch(lower)
		{
		case "a":
			nr = 6;
			break;
		case "b":
			nr = 9;
			break;
		case "c":
			nr = 12;
			break;
		case "d":
			nr = 15;
			break;
		case "e":
			nr = 18;
			break;
		case "f":
			nr = 21;
			break;
		case "g":
			nr = 24;
			break;
		case "h":
			nr = 27;
			break;
		case "i":
			nr = 30;
			break;
		case "j":
			nr = 33;
			break;
		case "k":
			nr = 36;
			break;
		case "l":
			nr = 39;
			break;
		case "m":
			nr = 42;
			break;
		case "n":
			nr = 45;
			break;
		case "o":
			nr = 48;
			break;
		case "p":
			nr = 51;
			break;
		case "q":
			nr = 54;
			break;
		case "r":
			nr = 57;
			break;
		case "s":
			nr = 60;
			break;
		case "t":
			nr = 63;
			break;
		case "u":
			nr = 66;
			break;
		case "v":
			nr = 69;
			break;
		case "w":
			nr = 72;
			break;
		case "x":
			nr = 75;
			break;
		case "y":
			nr = 78;
			break;
		case "z":
			nr = 81;
			break;
					
		}
	return	nr;
	}
	
	public static String numberToChar(double n)
	{	int num = (int)(n);
		String string = "";
		switch(num)
		{
		case 6:
			string = "a";
			break;
		case 9:
			string = "b";
			break;
		case 12:
			string = "c";
			break;
		case 15:
			string = "d";
			break;
		case 18:
			string = "e";
			break;
		case 21:
			string = "f";
			break;
		case 24:
			string = "g";
			break;
		case 27:
			string = "h";
			break;
		case 30:
			string = "i";
			break;
		case 33:
			string = "j";
			break;
		case 36:
			string = "k";
			break;
		case 39:
			string = "l";
			break;
		case 42:
			string = "m";
			break;
		case 45:
			string = "n";
			break;
		case 48:
			string = "o";
			break;
		case 51:
			string = "p";
			break;
		case 54:
			string = "q";
			break;
		case 57:
			string = "r";
			break;
		case 60:
			string = "s";
			break;
		case 63:
			string = "t";
			break;
		case 66:
			string = "u";
			break;
		case 69:
			string = "v";
			break;
		case 72:
			string = "w";
			break;
		case 75:
			string = "x";
			break;
		case 78:
			string = "y";
			break;
		case 81:
			string = "z";
			break;
			
		}
	return string;	
	}
}
