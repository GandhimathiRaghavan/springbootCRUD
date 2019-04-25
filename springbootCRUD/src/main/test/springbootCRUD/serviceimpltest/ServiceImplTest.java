package springbootCRUD.serviceimpltest;


	
	

	import static org.junit.Assert.assertEquals;
	import static org.junit.Assert.assertNotNull;
	import static org.junit.Assert.assertTrue;
	import static org.mockito.ArgumentMatchers.any;
	import static org.mockito.Mockito.doNothing;
	import static org.mockito.Mockito.doThrow;
	import static org.mockito.Mockito.times;
	import static org.mockito.Mockito.verify;
	import static org.mockito.Mockito.when;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Optional;

	import org.junit.After;
	import org.junit.AfterClass;
	import org.junit.Before;
	import org.junit.BeforeClass;
	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.junit.MockitoJUnitRunner;
	

import com.springbootcrud.example.entity.StudentEntity;
import com.springbootcrud.example.repository.Studentrepository;
import com.springbootcrud.example.service.Studentserviceimpl;

	@RunWith(MockitoJUnitRunner.class)
	public class ServiceImplTest {

		@Mock
		private Studentrepository Repo;

		@InjectMocks
		private Studentserviceimpl service;

		@BeforeClass
		public static void setUpTestClass() {
			System.out.println("In setUpTestClass method, runs before test class");
		}

		@Before
		public void setUp() {
			System.out.println("In setUp method, runs before every test");
			// MockitoAnnotations.initMocks(this);
		}
        @Test
		public void testUpsertEmployeeSuccessCase() {
			final StudentEntity student = new StudentEntity();
			when(Repo.save(student)).thenReturn(student);
			service.upsertStudent(student);
			verify(Repo, times(1)).save(student);
		}
        @Test
		public void testUpsertEmployeeThrowingException() {
			final StudentEntity student = new StudentEntity();
			when(Repo.save(student)).thenThrow(new RuntimeException());
			service.upsertStudent(student);
		}
        @Test
		public void testGetEmployeeSuccessCase() {
			final StudentEntity expected = new StudentEntity(1, "Ravindra", "G", "test@dbs.com", "9986343565");
			when(Repo.findById(expected.getId())).thenReturn(Optional.of(expected));
			final StudentEntity actual = service.getStudent(expected.getId());

			verify(Repo, times(1)).findById(expected.getId());

			assertNotNull(actual);
			assertEquals(expected, actual);
			assertEquals(expected.getId(), actual.getId());
		}
        @Test
		public void testGetAllEmployeesSuccessCase() {
			final List<StudentEntity> expectedStudent = new ArrayList<>();
			expectedStudent.add(new StudentEntity(1, "Ravindra", "G", "test@dbs.com", "9986343565"));
			when(Repo.findAll()).thenReturn(expectedStudent);
			final List<StudentEntity> actualstudent = service.getAllStudents();

			verify(Repo, times(1)).findAll();

			assertNotNull(actualstudent);
			assertEquals(1, actualstudent.size());
			assertTrue(expectedStudent.get(0).equals(actualstudent.get(0)));
		}
        @Test
		public void testDeleteEmployeeSuccessCase() {
			final Integer StudentId = 1;
			doNothing().when(Repo).deleteById(StudentId);
			service.deleteStudent(StudentId);

			verify(Repo, times(1)).deleteById(StudentId);
		}
        
        @Test
        public void testDeleteEmployeeThrowingException() {
			final Integer StudentId = 1;
			doThrow(new RuntimeException()).when(Repo).deleteById(any(Integer.class));
		service.deleteStudent(StudentId);
		}

		@After
		public void tearDown() {
			System.out.println("In tearDown method, runs after every test");
		}

		@AfterClass
		public static void tearDownTestClass() {
			System.out.println("In tearDownTestClass method, runs after test class");
		}

	}



