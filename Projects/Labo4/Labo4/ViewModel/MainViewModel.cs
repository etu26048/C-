using GalaSoft.MvvmLight;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Labo4.Model;
using GalaSoft.MvvmLight.Views;
using GalaSoft.MvvmLight.Ioc;
using System.Windows.Input;
using GalaSoft.MvvmLight.Command;

namespace Labo4.ViewModel
{
    public class MainViewModel : ViewModelBase, INotifyPropertyChanged
    {
        private ObservableCollection<Student> _students;
        private Student _selectedStudent;
        private INavigationService _navigationService;
        private ICommand _editStudentCommand;
        [PreferredConstructor]
        public MainViewModel(INavigationService navigationService)
        {
            _navigationService = navigationService;
            //Initialisation de la liste
            Students = new ObservableCollection<Student>(AllStudents.GetAllStudents());
        }
        public ObservableCollection<Student> Students
        {
            get
            {
                return _students;
            }

            set
            {
                _students = value;
                RaisePropertyChanged("Students");
            }
        }

        public Student SelectedStudent
        {
            get
            {
                return _selectedStudent;
            }

            set
            {
                _selectedStudent = value;
                if(_selectedStudent != null)
                {
                    RaisePropertyChanged("SelectedStudent");
                }
            }
        }

        public ICommand EditStudentCommand
        {
            get
            {
                if(this._editStudentCommand == null)
                {
                    this._editStudentCommand = new RelayCommand(()=>EditStudent());
                }
                return _editStudentCommand;
            }
        }
        private void EditStudent()
        {
            //Elément sélectionné ?
            if(CanExecute())
            {
                _navigationService.NavigateTo("SecondPage", SelectedStudent);
            }
        }
        public bool CanExecute()
        {
            return (SelectedStudent == null) ? false : true;
        }
        public MainViewModel()
        {
            Students = new ObservableCollection<Student>(AllStudents.GetAllStudents()); 
        }
    }
}
