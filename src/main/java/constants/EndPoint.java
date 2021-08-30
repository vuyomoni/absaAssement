package constants;

public class EndPoint {

	public static final String Get_All_Person="/persons";
	public static final String Get_Single_Person="/persons/{id}";
	public static final String Create_Person="/persons";
	public static final String Update_Person="/persons/{id}";
	public static final String Delete_Persons="/persons/{id}";
	
	public static final String Get_All_Dogs="https://dog.ceo/api/breeds/list/all";
	public static final String Get_Single_Dog="https://dog.ceo/api/breed/{name}/list";
    public static final String Get_dog_image="https://dog.ceo/api/breed/{name}/images/random";
}
