import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PostStatComponent } from './post-stat.component';

describe('PostStatComponent', () => {
  let component: PostStatComponent;
  let fixture: ComponentFixture<PostStatComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PostStatComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PostStatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
