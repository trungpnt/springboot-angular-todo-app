package com.trung.todo.validators;

import com.trung.todo.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {
    public static List<String> validateCategory(CategoryDto category){
        List<String> errors = new ArrayList<>();
        if(category == null){
            errors.add("Please fill in the name");
            errors.add("Please fill in the description");
            return errors;
        }

        if (StringUtils.isEmpty(category.getName())){
            errors.add("Please fill in the name");
        }

        if (StringUtils.isEmpty(category.getName())) {
            errors.add("Please fill in the name");
        }
        return errors;
    }

}
