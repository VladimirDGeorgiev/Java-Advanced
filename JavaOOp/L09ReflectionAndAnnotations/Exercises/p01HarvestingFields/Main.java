package JavaOOP.L09ReflectionAndAnnotations.Exercises.p01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Class harvest = RichSoilLand.class;
		Field[] fields = harvest.getDeclaredFields();

		String command = "";

		while (!"HARVEST".equals(command= reader.readLine())){
			switch (command){
				case "private":
					printModifier(fields,f->Modifier.isPrivate(f.getModifiers()));
					break;
				case "protected":
					printModifier(fields,f->Modifier.isProtected(f.getModifiers()));
					break;
				case "public":
					printModifier(fields,f->Modifier.isPublic(f.getModifiers()));
					break;
				case "all":
					Arrays.stream(fields).forEach(f->{
						System.out.println(String.format("%s %s %s"
						,Modifier.toString(f.getModifiers())
						,f.getType().getSimpleName()
						,f.getName()
								));
					});
					break;
					default:
						break;
			}

		}
	}
	public static void printModifier(Field[] fields, Predicate<Field> modifier){
		Arrays.stream(fields)
				.filter(modifier)
				.forEach(f->{
					System.out.println(String.format("%s %s %s"
							,Modifier.toString(f.getModifiers())
							,f.getType().getSimpleName()
							,f.getName()
					));
				});
	}
}
