package basic_class_03;

import java.util.LinkedList;
import java.util.Queue;

// 猫狗队列
// 实现一种狗猫队列的结构，要求如下：
// 用户可以调用add方法将cat类或dog类的实例放入队列中；
// 用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出；
// 用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出；
// 用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出；
// 用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例；
// 用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例；
// 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
public class Code_04_DogCatQueue {
	public static class Pet {
		private String type;

		public Pet(String type) {
			this.type = type;
		}

		public String getPetType() {
			return this.type;
		}
	}

	public static class Dog extends Pet {
		public Dog() {
			super("dog");
		}
	}

	public static class Cat extends Pet {
		public Cat() {
			super("cat");
		}
	}

	public static class CatDogEnter {
		private Pet pet;
		private int count;

		public CatDogEnter(Pet pet, int count) {
			this.pet = pet;
			this.count = count;
		}

		public Pet getPet() {
			return this.pet;
		}

		public int getCount() {
			return this.count;
		}

		public String getEnterPetType() {
			return this.pet.getPetType();
		}
	}

	public static class CatDogQueue {
		private Queue<CatDogEnter> catQueue;
		private Queue<CatDogEnter> dogQueue;
		int count;

		public CatDogQueue() {
			catQueue = new LinkedList<CatDogEnter>();
			dogQueue = new LinkedList<CatDogEnter>();
			count = 0;
		}

		// 用户可以调用add方法将cat类或dog类的实例放入队列中；
		public void add(Pet pet) {
			if (pet.getPetType().equals("cat")) {
				catQueue.add(new CatDogEnter(pet, count++));
			} else if (pet.getPetType().equals("dog")) {
				dogQueue.add(new CatDogEnter(pet, count++));
			} else {
				throw new RuntimeException("err, not dog or cat");
			}
		}

		// 用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出；
		public Pet pollAll() {
			if (isEmpty()) {
				throw new RuntimeException("Queue is empty!");
			} else if (isDogEmpty() && !isCatEmpty()) {
				return catQueue.poll().getPet();
			} else if (!isDogEmpty() && isCatEmpty()) {
				return dogQueue.poll().getPet();
			} else {
				if (catQueue.peek().getCount() < dogQueue.peek().getCount()) {
					return catQueue.poll().getPet();
				} else {
					return dogQueue.poll().getPet();
				}
			}
		}

		// 用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出；
		public Dog pollDog() {
			if (isDogEmpty()) {
				throw new RuntimeException("Dog queue is empty!");
			}
			return (Dog) this.dogQueue.poll().getPet();
		}

		// 用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出；
		public Cat pollCat() {
			if (isCatEmpty()) {
				throw new RuntimeException("Cat queue is empty!");
			}
			return (Cat) this.catQueue.poll().getPet();
		}

		// 用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例；
		public boolean isEmpty() {
			return this.dogQueue.isEmpty() && this.catQueue.isEmpty();
		}

		// 用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例；
		public boolean isDogEmpty() {
			return this.dogQueue.isEmpty();
		}

		// 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
		public boolean isCatEmpty() {
			return this.catQueue.isEmpty();
		}
	}
	
	public static void main(String[] args) {
        CatDogQueue test = new CatDogQueue();
        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();
        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
        
        while (!test.isDogEmpty()) {
            System.out.println(test.pollDog().getPetType());
        }
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getPetType());
        }
        
	}
}
