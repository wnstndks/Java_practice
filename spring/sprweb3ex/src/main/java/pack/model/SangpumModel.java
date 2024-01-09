package pack.model;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class SangpumModel {
    public ArrayList<String> sangProcess(SangpumBean bean) {
        ArrayList<String> dataList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            String data = bean.getSu() + " * " + i + " = " + (bean.getSu() * i);
            dataList.add(data);
        }

        return dataList;
    }
}
