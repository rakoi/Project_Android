package classeye.project.app.classeyes.apiClients;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChartApiClient {
    public static final String  url="http://68.183.73.119/api/student/";
    public static Retrofit retrofit=null;

    public static Retrofit getApiClient() {
        if(retrofit==null){
            return new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
